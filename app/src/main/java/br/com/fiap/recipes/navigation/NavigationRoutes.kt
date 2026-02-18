package br.com.fiap.recipes.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController

import androidx.navigation.compose.composable
import br.com.fiap.recipes.screens.HomeScreen
import br.com.fiap.recipes.screens.InitialScreen
import br.com.fiap.recipes.screens.LoginScreen

@Composable
fun NavigationRotes() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Destination.InitialScreen.route
    ){
        composable(Destination.InitialScreen.route){
            InitialScreen()
        }

        composable(Destination.HomeScreen.route) {
            HomeScreen()
        }

        composable(Destination.LoginScreen.route) {
            LoginScreen() 
        }
    }
}