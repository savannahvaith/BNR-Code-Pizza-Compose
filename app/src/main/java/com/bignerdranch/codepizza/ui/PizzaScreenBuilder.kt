import Topping.Pepperoni
import ToppingPlacement.Left
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.text.toUpperCase
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bignerdranch.codepizza.R

@Preview
@Composable
fun PizzaBuilderScreen(
    modifier: Modifier = Modifier,
) {
    Column(modifier = modifier) {
        ToppingList(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f, fill = true)
        )
        OrderButton(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        )
    }

}


@Composable
private fun OrderButton(
    modifier: Modifier = Modifier,
) {
    Button(
        modifier = modifier,
        onClick = { /*TODO*/ }
    ) {
        Text(
            text = stringResource(id = R.string.place_order_button)
                .toUpperCase(Locale.current)
        )
    }
}

@Composable
private fun ToppingList(
    modifier: Modifier = Modifier,
) {
    ToppingCell(
        topping = Pepperoni,
        placement = Left,
        onClickTopping = {},
        modifier = modifier,
    )
}
