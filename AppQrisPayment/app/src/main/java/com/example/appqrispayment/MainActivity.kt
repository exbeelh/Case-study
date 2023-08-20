package com.example.appqrispayment

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.appqrispayment.navigation.TopLevelDestination
import com.example.appqrispayment.presentation.screen.home.HomeScreen
import com.example.appqrispayment.ui.theme.AppQrisPaymentTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppQrisPaymentTheme {
                // A surface container using the 'background' color from the theme
                TopLevelDestination()
            }
        }
    }
}
