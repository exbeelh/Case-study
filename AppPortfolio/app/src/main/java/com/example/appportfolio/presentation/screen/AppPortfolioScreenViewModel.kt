package com.example.appportfolio.presentation.screen

import androidx.lifecycle.ViewModel
import com.example.appportfolio.data.dummyChartData
import com.example.appportfolio.data.lineChartData
import com.example.appportfolio.data.model.ChartData
import com.example.appportfolio.data.model.LineChart
import com.example.appportfolio.data.repository.ChartDataRepository

class AppPortfolioScreenViewModel: ViewModel() {
    private val chartDataRepository = ChartDataRepository(dummyChartData, lineChartData)

    fun getAllChartData(): List<ChartData> {
        return chartDataRepository.getAllChartData()
    }

    fun getLineData(): List<LineChart> {
        return chartDataRepository.getAllLineChart()
    }

    fun getChartDataByLabel(label: String): ChartData? {
        return chartDataRepository.getChartDataByLabel(label)
    }
}