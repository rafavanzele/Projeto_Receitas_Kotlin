package br.com.fiap.recipes.repository

import br.com.fiap.recipes.R
import br.com.fiap.recipes.components.DifficultLevel
import br.com.fiap.recipes.components.Recipe
import br.com.fiap.recipes.components.User
import br.com.fiap.recipes.model.Category
import java.time.LocalDate

fun getAllRecipes() = listOf<Recipe>(
    Recipe(
        id = 1,
        category = Category(id = 6000, name = "Desserts"),
        user = User(id = 100, name = "João Silva"),
        difficultLevel = DifficultLevel.BEGINNER,
        name = "Bolo floresta negra",
        description = "bolo de massa de chocolate recheado com creme e cerejas frescas",
        cookingTime = 40,
        createdAt = LocalDate.now(),
        image = R.drawable.bolo_de_chocolate
    ),
    Recipe(
        id = 2,
        category = Category(id = 5000, name = "Pasta"),
        user = User(id = 200, name = "Maria Soares"),
        difficultLevel = DifficultLevel.INTERMEDIATE,
        name = "Macarronada",
        description = "massa fresca italiana ao molho sugo",
        cookingTime = 60,
        createdAt = LocalDate.now(),
        image = R.drawable.macarronada
    ),
    Recipe(
        id = 3,
        category = Category(id = 4000, name = "Chicken"),
        user = User(id = 300, name = "Francisco Sone"),
        difficultLevel = DifficultLevel.INTERMEDIATE,
        name = "Frango assado",
        description = "Frango assado com vegetais",
        cookingTime = 90,
        createdAt = LocalDate.now(),
        image = R.drawable.frango_assado
    ),
    Recipe(
        id = 4,
        category = Category(id = 3000, name = "Drink"),
        user = User(id = 400, name = "Lionel Assunção"),
        difficultLevel = DifficultLevel.BEGINNER,
        name = "Limonada",
        description = "Bebida de suco de limão",
        cookingTime = 15,
        createdAt = LocalDate.now(),
        image = R.drawable.limonada
    ),
    Recipe(
        id = 5,
        category = Category(id = 2000, name = "Salad"),
        user = User(id = 500, name = "Salomita Reina"),
        difficultLevel = DifficultLevel.INTERMEDIATE,
        name = "Salada grega",
        description = "Salada com vegetais sortidos, molho especial e torradas",
        cookingTime = 30,
        createdAt = LocalDate.now(),
        image = R.drawable.salada
    ),
    Recipe(
        id = 6,
        category = Category(id = 1000, name = "Desserts"),
        user = User(id = 600, name = "Marechal Soares"),
        difficultLevel = DifficultLevel.ADVANCED,
        name = "Costela assada",
        description = "Costela assada com molho barbecue",
        cookingTime = 120,
        createdAt = LocalDate.now(),
        image = R.drawable.costela
    ),
    Recipe(
        id = 7,
        category = Category(id = 500, name = "Pasta"),
        user = User(id = 700, name = "Denise Correa"),
        difficultLevel = DifficultLevel.ADVANCED,
        name = "Nhoque de batata",
        description = "Nhoque de massa de batata ao molho bolonhesa",
        cookingTime = 120,
        createdAt = LocalDate.now(),
        image = R.drawable.nhoque
    )
)

fun getRecipesByCategory(id: Int) = getAllRecipes()
    .filter{ recipe ->
        recipe.category.id == id
    }




















