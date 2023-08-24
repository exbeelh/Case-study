package com.example.appportfolio.presentation.screen

import android.annotation.SuppressLint
import android.graphics.Typeface
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import co.yml.charts.axis.AxisData
import co.yml.charts.common.components.Legends
import co.yml.charts.common.extensions.formatToSinglePrecision
import co.yml.charts.common.model.PlotType
import co.yml.charts.common.model.Point
import co.yml.charts.common.utils.DataUtils
import co.yml.charts.ui.linechart.LineChart
import co.yml.charts.ui.linechart.model.GridLines
import co.yml.charts.ui.linechart.model.IntersectionPoint
import co.yml.charts.ui.linechart.model.Line
import co.yml.charts.ui.linechart.model.LineChartData
import co.yml.charts.ui.linechart.model.LinePlotData
import co.yml.charts.ui.linechart.model.LineStyle
import co.yml.charts.ui.linechart.model.SelectionHighlightPoint
import co.yml.charts.ui.linechart.model.SelectionHighlightPopUp
import co.yml.charts.ui.linechart.model.ShadowUnderLine
import co.yml.charts.ui.piechart.charts.DonutPieChart
import co.yml.charts.ui.piechart.models.PieChartConfig
import co.yml.charts.ui.piechart.models.PieChartData
import co.yml.charts.ui.piechart.utils.proportion
import com.example.appportfolio.R
import com.example.appportfolio.data.model.ChartData
import com.example.appportfolio.data.model.LineChart

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: AppPortfolioScreenViewModel
) {
    val data = viewModel.getAllChartData()
    val lineChartData = viewModel.getLineData()

    Scaffold(
        modifier = Modifier.fillMaxSize(),
    ) {
        LocalContext.current
        LazyColumn(content = {
            items(data.size) { item ->
                when (item) {
                    0 -> {
                        Text(
                            modifier = Modifier.padding(12.dp),
                            text = stringResource(R.string.potfolio),
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold
                        )
                        Box(
                            modifier = Modifier
                                .padding(2.dp)
                                .fillMaxWidth()
                        ) {
                            Spacer(modifier = Modifier.height(20.dp))
                            SimpleDonutChart(data, navController)
                        }
                    }
                    1 -> {
                        Text(
                            modifier = Modifier.padding(12.dp),
                            text = stringResource(R.string.report_per_month),
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold
                        )
                        SingleLineChartWithGridLines(getLineChartData(lineChartData))
                    }
                }
            }
        })
    }
}

fun getLineChartData(data: List<LineChart>): List<Point> {
    val list = arrayListOf<Point>()
    data.forEach { item ->
        list.add(
            Point(item.month.toFloat(), item.value.toFloat())
        )
    }
    return list
}


fun getLabelColor(): List<Color> {
    return listOf(
        Color(0xFF5F0A87),
        Color(0xFF20BF55),
        Color(0xFFA40606),
        Color(0xFFF53844)
    )
}

fun getDonutChartData(chartData: List<ChartData>): PieChartData {
    val slices = chartData.mapIndexed { index, data ->
        PieChartData.Slice(data.label, data.percentage, getLabelColor()[index])
    }
    return PieChartData(
        slices = slices,
        plotType = PlotType.Donut
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun SimpleDonutChart(
    donutChartData: List<ChartData>,
    navController: NavController
) {
    rememberModalBottomSheetState()
    rememberCoroutineScope()
    val data = getDonutChartData(donutChartData)
    // Sum of all the values
    val sumOfValues = data.totalLength

    // Calculate each proportion value
    data.slices.proportion(sumOfValues)
    val pieChartConfig =
        PieChartConfig(
            labelVisible = true,
            strokeWidth = 120f,
            labelColor = Color.Black,
            activeSliceAlpha = .9f,
            isEllipsizeEnabled = true,
            labelTypeface = Typeface.defaultFromStyle(Typeface.BOLD),
            isAnimationEnable = true,
            chartPadding = 25,
            labelFontSize = 42.sp,
        )
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(500.dp)
    ) {
        Legends(legendsConfig = DataUtils.getLegendsConfigFromPieChartData(pieChartData = data, 3))
        DonutPieChart(
            modifier = Modifier
                .fillMaxWidth()
                .height(400.dp),
            data,
            pieChartConfig
        ) { slice ->
            navController.navigate("detail/${slice.label}")
        }
    }
}

@Composable
private fun SingleLineChartWithGridLines(pointsData: List<Point>) {
    val steps = 5
    val xAxisData = AxisData.Builder()
        .axisStepSize(30.dp)
        .topPadding(105.dp)
        .steps(pointsData.size - 1)
        .labelData { i -> pointsData[i].x.toInt().toString() }
        .labelAndAxisLinePadding(15.dp)
        .build()
    val yAxisData = AxisData.Builder()
        .steps(steps)
        .labelAndAxisLinePadding(20.dp)
        .labelData { i ->
            val yMin = pointsData.minOf { it.y }
            val yMax = pointsData.maxOf { it.y }
            val yScale = (yMax - yMin) / steps
            ((i * yScale) + yMin).formatToSinglePrecision()
        }.build()
    val data = LineChartData(
        linePlotData = LinePlotData(
            lines = listOf(
                Line(
                    dataPoints = pointsData,
                    LineStyle(),
                    IntersectionPoint(),
                    SelectionHighlightPoint(),
                    ShadowUnderLine(),
                    SelectionHighlightPopUp()
                )
            )
        ),
        xAxisData = xAxisData,
        yAxisData = yAxisData,
        gridLines = GridLines()
    )
    LineChart(
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp),
        lineChartData = data
    )
}