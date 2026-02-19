package br.com.fiap.recipes.repository

import androidx.compose.ui.graphics.Color
import br.com.fiap.recipes.R
import br.com.fiap.recipes.model.Category

fun getAllCategories() = listOf<Category>(
    Category(id = 1000, name = "Breakfast", image = R.drawable.coffee_cup, background = Color(0XFFABF2E9)),
    Category(id = 2000, name = "Meat", image = R.drawable.meat, background = Color(0XFFABF2E9)),
    Category(id = 3000, name = "Cake", image = R.drawable.cake, background = Color(0XFFABF2E9)),
    Category(id = 4000, name = "Chicken", image = R.drawable.chicken, background = Color(0XFFABF2E9)),
    Category(id = 5000, name = "Drink", image = R.drawable.drink, background = Color(0XFFABF2E9)),
    Category(id = 6000, name = "Fish", image = R.drawable.fish, background = Color(0XFFABF2E9)),
    Category(id = 7000, name = "Salad", image = R.drawable.salad, background = Color(0XFFABF2E9)),
)

fun getCategoryById(id: Int) = getAllCategories()
    .find {category ->
        category.id == id
    }