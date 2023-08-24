package com.example.appqrispayment.presentation.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.appqrispayment.util.formatConverter

@Composable
fun NominalCard(
    nominal: Long,
    modifier: Modifier = Modifier
) {
    Card (
        modifier = modifier.fillMaxWidth()
    ) {
        Column (
            modifier = modifier.padding(16.dp)
        ) {
            Text(
                text = "Balance",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.SemiBold
            )
            Text(
                text = "Rp. " + formatConverter(nominal),
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold
            )
        }
    }
}