package com.example.appqrispayment.presentation.screen.home

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.appqrispayment.presentation.component.NominalCard
import com.example.appqrispayment.util.formatConverter

@Composable
fun HomeScreen(
    viewModel: HomeScreenViewModel = hiltViewModel(),
    @SuppressLint("ModifierParameter") modifier: Modifier = Modifier
) {
    val userData by viewModel.userData.observeAsState()

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Spacer(modifier = modifier.height(40.dp))
        Text(
            text = "Welcome Back",
            style = MaterialTheme.typography.headlineSmall,
            modifier = modifier.padding(bottom = 5.dp)
        )
        userData?.let {
            Text(
                text = it.userName,
                style = MaterialTheme.typography.headlineSmall
            )
            Spacer(modifier = modifier
                .fillMaxWidth()
                .height(30.dp))
            NominalCard(nominal = it.balance)
        }
    }
}