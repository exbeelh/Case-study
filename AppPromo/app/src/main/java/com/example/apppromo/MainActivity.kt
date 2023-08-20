package com.example.apppromo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.apppromo.navigation.AppNavHost
import com.example.apppromo.ui.theme.AppPromoTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppPromoTheme {
                AppNavHost()
            }
        }
    }
}