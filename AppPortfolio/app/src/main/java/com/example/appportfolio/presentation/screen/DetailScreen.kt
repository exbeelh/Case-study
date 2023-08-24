package com.example.appportfolio.presentation.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.appportfolio.presentation.component.CardHistory
import com.example.appportfolio.presentation.component.TopAppBar

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun DetailScreen (
    label: String,
    navController: NavController,
    viewModel: AppPortfolioScreenViewModel
) {
    val dataByLabel = viewModel.getChartDataByLabel(label)

    Scaffold (
        topBar = { TopAppBar(title = dataByLabel!!.label, navController = navController) }
    ) {
        Column (
            modifier = Modifier.padding(16.dp)
        ) {
            Spacer(modifier = Modifier.fillMaxWidth().height(50.dp))
            dataByLabel?.data?.forEach { history ->
                CardHistory(date = history.trx_date, nominal = history.nominal)
            }
        }
    }
}