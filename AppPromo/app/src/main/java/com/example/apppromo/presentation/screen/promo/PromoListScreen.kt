package com.example.apppromo.presentation.screen.promo

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.apppromo.presentation.component.PromoCard
import com.example.apppromo.presentation.component.PromoCardSample
import com.example.apppromo.presentation.component.TopAppBar

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PromoListScreenSample(
    modifier: Modifier = Modifier
) {
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
    Scaffold(
        topBar = { TopAppBar(title = "Promo", scrollBehavior = scrollBehavior) }
    ) {
        Column(
            modifier = modifier.padding(16.dp)
        ) {
            Spacer(modifier = modifier.height(50.dp))
            PromoCardSample()
            PromoCardSample()
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PromoListScreen(
    modifier: Modifier = Modifier,
    promoListViewModel: PromoListViewModel = hiltViewModel(),
    navController: NavController
) {
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
    val promos = promoListViewModel.promos.observeAsState(listOf()).value
    Scaffold (
        topBar = { TopAppBar(title = "Promo", scrollBehavior = scrollBehavior) }
    ) {
        Column (
            modifier = modifier.padding(16.dp)
        ) {
            Spacer(modifier = modifier.height(50.dp))
            LazyColumn {
                items(promos) { promos ->
                    PromoCard(promo = promos, navController = navController)
                }
            }
        }
    }
}

@Preview
@Composable
fun PromoListScreenPreview() {
    PromoListScreenSample()
}