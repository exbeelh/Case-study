package com.example.appportfolio.data.repository

import com.example.appportfolio.data.model.ChartData
import com.example.appportfolio.data.model.LineChart

class ChartDataRepository(
    private val chartDataList: List<ChartData>,
    private val lineChart: List<LineChart>
) {
    fun getAllChartData(): List<ChartData> {
        return chartDataList
    }

    fun getAllLineChart(): List<LineChart> {
        return lineChart
    }

    fun getChartDataByLabel(label: String): ChartData? {
        return chartDataList.find { it.label == label }
    }
}