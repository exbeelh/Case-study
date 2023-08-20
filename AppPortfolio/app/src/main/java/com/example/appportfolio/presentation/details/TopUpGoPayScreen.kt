package com.example.appportfolio.presentation.details

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.appportfolio.presentation.component.CardHistory

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun TopUpGoPayScreen(
    navController: NavController
) {
    Scaffold {
        Column (
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = "Top Up GoPay",
                style = MaterialTheme.typography.headlineSmall
            )
            CardHistory(date = "21/10/2023", nominal = "200.000")
            CardHistory(date = "20/10/2023", nominal = "195.000")
            CardHistory(date = "19/10/2023", nominal = "5.000.000")
        }
    }
}