package com.example.appqrispayment.presentation.screen.history

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.appqrispayment.util.formatConverter

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HistoryScreen(
    viewModel: HistoryScreenViewModel = hiltViewModel(),
    @SuppressLint("ModifierParameter") modifier: Modifier = Modifier
) {
    val transactions by viewModel.transactions.collectAsState(listOf())

    LazyColumn {
        items(transactions) { transaction ->
            Card (
                modifier = modifier.fillMaxWidth().height(120.dp).padding(10.dp),

            ) {
                Column {
                    Text(
                        text = transaction.merchant,
                        modifier = modifier.padding(10.dp),
                        style = MaterialTheme.typography.titleMedium
                    )
                    Text(
                        text = formatConverter(transaction.nominal),
                        modifier = modifier.padding(10.dp),
                        style = MaterialTheme.typography.headlineSmall
                    )
                }
            }
        }
    }
}