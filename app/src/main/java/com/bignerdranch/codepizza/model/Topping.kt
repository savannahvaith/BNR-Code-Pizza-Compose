import androidx.annotation.StringRes
import com.bignerdranch.codepizza.R

enum class Topping (
    @StringRes val toppingName: Int
){
    Basil(toppingName = R.string.topping_basil),
    Mushroom(toppingName = R.string.topping_mushrooms),
    Olive(toppingName = R.string.topping_olive),
    Peppers(toppingName = R.string.topping_peppers),
    Pepperoni(toppingName =  R.string.topping_pepperoni),
    Pineapple(toppingName = R.string.topping_pineapple)
}
