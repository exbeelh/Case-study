package com.example.appportfolio

import com.example.appportfolio.data.model.ChartData
import com.example.appportfolio.data.model.LineChart
import com.example.appportfolio.data.repository.ChartDataRepository
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class GetDataByLabelUnitTest {
    private lateinit var chartDataRepository: ChartDataRepository

    @Before
    fun setUp() {
        val chartDataList = listOf(
            ChartData(1, "Label1", 50f, emptyList()),
            ChartData(2, "Label2", 30f, emptyList()),
            ChartData(3, "Label3", 20f, emptyList())
        )

        val lineChartList = listOf(
            LineChart(1, 2),
            LineChart(2,6)
        )

        chartDataRepository = ChartDataRepository(chartDataList, lineChartList)
    }

    @Test
    fun getLabel() {
        val existingLabel = 1
        val existingChartData = chartDataRepository.getChartDataById(existingLabel)
        Assert.assertEquals(existingLabel, existingChartData?.id)

        val nonExistingLabel = 5
        val nonExistingChartData = chartDataRepository.getChartDataById(nonExistingLabel)
        Assert.assertEquals(null, nonExistingChartData)
    }
}