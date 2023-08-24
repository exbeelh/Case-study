package com.example.appqrispayment.util

import java.text.NumberFormat
import java.util.Locale

fun formatConverter(number: Long): String {
    val indonesianLocale = Locale("id", "ID")
    val numberFormat = NumberFormat.getNumberInstance(indonesianLocale)
    return numberFormat.format(number)
}