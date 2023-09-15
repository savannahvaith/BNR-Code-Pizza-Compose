import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.text.toUpperCase
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bignerdranch.codepizza.R
import com.bignerdranch.codepizza.model.Pizza
import java.text.NumberFormat

@Preview
@Composable
fun PizzaBuilderScreen(
    modifier: Modifier = Modifier,
) {
    var pizza by rememberSaveable { mutableStateOf(Pizza())}

    Column(modifier = modifier) {
        ToppingList(
            pizza = pizza,
            onEditPizza = { pizza = it}, // same as newPizza -> pizza = newPizza
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f, fill = true)
        )
        OrderButton(
            pizza = pizza,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        )
    }

}

@Composable
private fun OrderButton(
    pizza: Pizza,
    modifier: Modifier = Modifier,
) {
    Button(
        modifier = modifier,
        onClick = { /*TODO*/ }
    ) {
        val currencyFormatter = remember { NumberFormat.getCurrencyInstance()}
        val price = currencyFormatter.format(pizza.price)
        Text(
            text = stringResource(id = R.string.place_order_button, price)
                .toUpperCase(Locale.current)
        )
    }
}

@Composable
private fun ToppingList(
    modifier: Modifier = Modifier,
    pizza: Pizza,
    onEditPizza: (Pizza) -> Unit
) {
    LazyColumn(
        modifier = modifier
    ){
        items(Topping.values()) { topping ->
            ToppingCell(
                topping = topping,
                placement = pizza.toppings[topping],
                onClickTopping = {
                    val isOnPizza = pizza.toppings[topping] != null
                    onEditPizza(pizza.withTopping(
                        topping = topping,
                        placement = if (isOnPizza) {
                            null
                        } else {
                            ToppingPlacement.All
                        }
                    ))
                }
            )
        }
    }
}

