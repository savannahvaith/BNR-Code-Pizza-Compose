package com.bignerdranch.codepizza.model

import Topping
import ToppingPlacement

data class Pizza(
    val toppings: Map<Topping, ToppingPlacement> = emptyMap()
){
    fun withTopping(topping: Topping, placement: ToppingPlacement?): Pizza {
        return copy(
            toppings = if (placement == null) {
                toppings - topping
            } else {
                toppings + (topping to placement)
            }
        )
    }
}
