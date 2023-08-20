package com.example.apppromo.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.apppromo.presentation.screen.promo.PromoListScreen
import com.example.apppromo.presentation.screen.promodetail.PromoDetailScreen
import com.example.apppromo.util.Constant.PROMO_ARGUMENT_KEY

@Composable
fun AppNavHost (
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navController,
        startDestination = "promos"
    ) {
        composable(route = "promos") {
            PromoListScreen(
                navController = navController
            )
        }
        composable(
            route = "promos/{promoId}",
            arguments = listOf(navArgument(PROMO_ARGUMENT_KEY) {
                type = NavType.IntType
            })
        ) {
            PromoDetailScreen()
        }
    }
}