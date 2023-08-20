package com.example.appqrispayment.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.appqrispayment.presentation.common.PaymentSuccess
import com.example.appqrispayment.presentation.screen.history.HistoryScreen
import com.example.appqrispayment.presentation.screen.home.HomeScreen
import com.example.appqrispayment.presentation.screen.scan.ScanScreen

sealed class Screen (val route: String) {
    object Home: Screen(route = "home_screen")
    object Scan: Screen(route = "scan_screen")
    object History: Screen(route = "history_screen")
}

@Composable
fun AppNavGraph(
    navHostController: NavHostController,
) {
    NavHost(
        navController = navHostController,
        startDestination = Screen.Home.route
    ) {
        composable(route = Screen.Home.route) {
            HomeScreen()
        }
        composable(route = Screen.Scan.route) {
            ScanScreen(navController = navHostController)
        }
        composable(route = Screen.History.route) {
            HistoryScreen()
        }
        composable(route = "payment-success") {
            PaymentSuccess(navController = navHostController)
        }
    }
}