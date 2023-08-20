package com.example.appqrispayment.presentation.common

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.appqrispayment.navigation.Screen

@Composable
fun PaymentSuccess(
    modifier: Modifier = Modifier,
    navController: NavController
) {
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Payment Success", style = MaterialTheme.typography.headlineLarge)
        Button(
            onClick = { navController.navigate(Screen.Home.route)
            }
        ) {
            Text(text = "Back To Home")
        }
    }
}