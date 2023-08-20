package com.example.appportfolio.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.appportfolio.presentation.HomeScreen
import com.example.appportfolio.presentation.details.LainnyaScreen
import com.example.appportfolio.presentation.details.QRISScreen
import com.example.appportfolio.presentation.details.TarikTunaiScreen
import com.example.appportfolio.presentation.details.TopUpGoPayScreen

@Composable
fun AppNavGraph(
    navController: NavHostController = rememberNavController(),
) {
    NavHost(
        navController = navController,
        startDestination = "home"
    ) {
        composable(route = "home") {
            HomeScreen(navController = navController)
        }
        composable(route = "qrispayment") {
            QRISScreen(navController = navController)
        }
        composable(route = "tariktunai") {
            TarikTunaiScreen(navController = navController)
        }
        composable(route = "topupgopay") {
            TopUpGoPayScreen(navController = navController)
        }
        composable(route = "lainnya") {
            LainnyaScreen(navController = navController)
        }
    }
}