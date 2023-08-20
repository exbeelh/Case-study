package com.example.appportfolio.data.model

data class ChartData(
    val label: String,
    val percentage: Float,
    val data: List<Transaction>
)

data class Transaction(
    val trx_date: String,
    val nominal: Int
)