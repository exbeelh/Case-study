package com.example.appqrispayment.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.History
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.QrCodeScanner
import androidx.compose.ui.graphics.vector.ImageVector

sealed class NavigationBar (
    var route: String,
    val title: String,
    val icon: ImageVector
) {
    object Home: NavigationBar(
        route = "home_screen",
        title = "Home",
        icon = Icons.Default.Home
    )
    object Scan: NavigationBar(
        route = "scan_screen",
        title = "QRIS",
        icon = Icons.Default.QrCodeScanner
    )
    object History: NavigationBar(
        route = "history_screen",
        title = "History",
        icon = Icons.Default.History
    )
}