package br.com.fiap.recipes.components

import androidx.annotation.DrawableRes
import br.com.fiap.recipes.model.Category
import java.time.LocalDate

data class Recipe(
    val id: Int = 0,
    val category: Category,
    val user: User,
    val difficultLevel: DifficultLevel,
    val name: String = "",
    val description: String = "",
    val cookingTime: Int = 0,
    val createdAt: LocalDate = LocalDate.now(),
    @DrawableRes val image: Int
)
