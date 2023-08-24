package com.example.appportfolio.data

import com.example.appportfolio.data.model.ChartData
import com.example.appportfolio.data.model.LineChart
import com.example.appportfolio.data.model.Transaction

val dummyChartData = listOf(
    ChartData(
        label = "Tarik Tunai",
        percentage = 55f,
        data = listOf(
            Transaction("21/01/2023", 1000000),
            Transaction("20/01/2023", 500000),
            Transaction("19/01/2023", 1000000)
        )
    ),
    ChartData(
        label = "QRIS Payment",
        percentage = 31f,
        data = listOf(
            Transaction("21/01/2023", 159000),
            Transaction("20/01/2023", 35000),
            Transaction("19/01/2023", 1500)
        )
    ),
    ChartData(
        label = "Topup Gopay",
        percentage = 7.7f,
        data = listOf(
            Transaction("21/01/2023", 200000),
            Transaction("20/10/2023", 195000),
            Transaction("19/01/2023", 500000)
        )
    ),
    ChartData(
        label = "Lainnya",
        percentage = 7.7f,
        data = listOf(
            Transaction("21/01/2023", 1000000),
            Transaction("20/10/2023", 500000),
            Transaction("19/01/2023", 1000000)
        )
    )
)

val lineChartData = listOf<LineChart>(
    LineChart(1, 3),
    LineChart(2, 7),
    LineChart(3, 8),
    LineChart(4, 10),
    LineChart(5, 5),
    LineChart(6, 10),
    LineChart(7, 1),
    LineChart(8, 3),
    LineChart(9, 5),
    LineChart(10, 10),
    LineChart(11, 7),
    LineChart(12, 7),
)