package me.bytebeats.views.charts.app.ui.screen.pie

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import me.bytebeats.views.charts.pie.PieChartData
import kotlin.random.Random

/**
 * Created by bytebeats on 2021/9/30 : 12:03
 * E-mail: happychinapc@gmail.com
 * Quote: Peasant. Educated. Worker
 */
class PieChartDataModel {
    private val colors = mutableListOf<Color>(
        Color(0XFFF44336),
        Color(0XFFE91E63),
        Color(0XFF9C27B0),
        Color(0XFF673AB7),
        Color(0XFF3F51B5),
        Color(0XFF03A9F4),
        Color(0XFF009688),
        Color(0XFFCDDC39),
        Color(0XFFFFC107),
        Color(0XFFFF5722),
        Color(0XFF795548),
        Color(0XFF9E9E9E),
        Color(0XFF607D8B)
    )

    var sliceThickness by mutableStateOf(25F)

    var pieChartData by mutableStateOf(
        PieChartData(
            slices = listOf(
                PieChartData.Slice(
                    randomLength(),
                    randomColor()
                ),
                PieChartData.Slice(randomLength(), randomColor()),
                PieChartData.Slice(randomLength(), randomColor())
            )
        )
    )

    val slices
        get() = pieChartData.slices

    fun addSlice() {
        pieChartData = pieChartData.copy(
            slices = slices.toMutableList().apply {
                add(PieChartData.Slice(randomLength(), randomColor()))
            }.toList()
        )
    }

    fun removeSlice() {
        pieChartData = pieChartData.copy(
            slices = slices.toMutableList().apply {
                val lastSlice = slices.last()
                colors.add(lastSlice.color)
                remove(lastSlice)
            }.toList()
        )
    }

    private fun randomLength(): Float = Random.Default.nextInt(10, 30).toFloat()
    private fun randomColor(): Color {
        val randomIndex = Random.Default.nextInt(colors.size)
        return colors.removeAt(randomIndex)
    }
}