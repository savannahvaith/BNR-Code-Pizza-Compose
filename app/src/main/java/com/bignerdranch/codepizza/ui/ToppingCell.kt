import Topping.*
import ToppingPlacement.*
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Checkbox
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.Modifier.Companion
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun ToppingCell(
    topping: Topping,
    placement: ToppingPlacement?,
    modifier: Modifier = Modifier, // when added here, the children don't need to instantiate
    onClickTopping: () -> Unit
) {
    Log.d("ToppingCell", "Called ToppingCell for $topping")
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier // uses modifier from ToppingCell
            .clickable { onClickTopping }
            .padding(
                vertical = 4.dp,
                horizontal = 16.dp
            )
    ) {
        Checkbox(checked = (placement != null), onCheckedChange = { onClickTopping() })
        Column(modifier = modifier
            .weight(1f, fill = true) // On click the entire row is highlighted.
        ) {
            Text(
                text = stringResource(id = topping.toppingName),
                style = MaterialTheme.typography.body1
            )
            if(placement != null ) {
                Text(
                    text = stringResource(id = placement.label),
                    style = MaterialTheme.typography.body2
                    )
            }
        }
    }
}

// Previews can't have parameters in the func declaration
@Preview
@Composable
private fun ToppingCellPreviewOnLeftHalf(){
    ToppingCell(
        topping = Peppers,
        placement = Left,
        onClickTopping = {}
    )
}

@Preview
@Composable
private fun ToppingCellPreviewNotOnPizza(){
    ToppingCell(
        topping = Pepperoni,
        placement = null ,
        onClickTopping = {}
    )
}
