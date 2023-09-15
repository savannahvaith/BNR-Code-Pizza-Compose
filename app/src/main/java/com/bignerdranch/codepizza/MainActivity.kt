package com.bignerdranch.codepizza

import PizzaBuilderScreen
import Topping.*
import ToppingCell
import ToppingPlacement.*
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
               PizzaBuilderScreen()
        }
    }
}
