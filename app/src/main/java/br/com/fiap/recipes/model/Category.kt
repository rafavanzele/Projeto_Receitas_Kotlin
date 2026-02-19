package br.com.fiap.recipes.model

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.Color
import br.com.fiap.recipes.R

data class Category(
    val id: Int = 0,
    val name: String = "Category",
    @DrawableRes val image: Int? = R.drawable.camera,
    val background: Color = Color.Gray
)
