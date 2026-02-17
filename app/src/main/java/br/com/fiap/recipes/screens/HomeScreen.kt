package br.com.fiap.recipes.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import br.com.fiap.recipes.ui.theme.RecipesTheme

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    Surface(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Scaffold(
            topBar = {},
            bottomBar = {},
            floatingActionButton = {},
        ) { paddingValues ->
            Column (
                modifier = Modifier
                    .padding(paddingValues)
            ) { }
        }
    }
}

@Preview
@Composable
private fun HomeScreenPreview() {
    RecipesTheme() {
        HomeScreen()
    }
}