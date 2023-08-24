package com.example.appportfolio.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.appportfolio.presentation.screen.AppPortfolioScreenViewModel
import com.example.appportfolio.presentation.screen.DetailScreen
import com.example.appportfolio.presentation.screen.HomeScreen

@Composable
fun AppNavGraph(
    navController: NavHostController = rememberNavController(),
) {
    NavHost(
        navController = navController,
        startDestination = "home"
    ) {
        composable(route = "home") {
            HomeScreen(navController = navController, viewModel = AppPortfolioScreenViewModel())
        }
        composable(route = "detail/{label}") { backStackEntry ->
            backStackEntry.arguments?.getString("label")?.let {
                DetailScreen(
                    label = it,
                    navController = navController,
                    viewModel = AppPortfolioScreenViewModel())
            }
        }
    }
}