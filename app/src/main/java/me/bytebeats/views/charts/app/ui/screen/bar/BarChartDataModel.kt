package me.bytebeats.views.charts.app.ui.screen.bar

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import me.bytebeats.views.charts.bar.BarChartData
import me.bytebeats.views.charts.bar.render.label.SimpleLabelDrawer
import kotlin.random.Random


/**
 * Created by bytebeats on 2021/9/30 : 19:39
 * E-mail: happychinapc@gmail.com
 * Quote: Peasant. Educated. Worker
 */
class BarChartDataModel {
    private var colors = mutableListOf(
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

    var labelDrawer by mutableStateOf(SimpleLabelDrawer(drawLocation = SimpleLabelDrawer.DrawLocation.Inside))
        private set

    var barChartData by mutableStateOf(
        BarChartData(
            bars = listOf(
                BarChartData.Bar(
                    label = "Bar 1",
                    value = randomValue(),
                    color = randomColor()
                ),
                BarChartData.Bar(
                    label = "Bar 2",
                    value = randomValue(),
                    color = randomColor()
                ),
                BarChartData.Bar(
                    label = "Bar 3",
                    value = randomValue(),
                    color = randomColor()
                ),
                BarChartData.Bar(
                    label = "Bar 4",
                    value = randomValue(),
                    color = randomColor()
                ),
            )
        )
    )

    val bars: List<BarChartData.Bar>
        get() = barChartData.bars

    var labelLocation: SimpleLabelDrawer.DrawLocation = SimpleLabelDrawer.DrawLocation.Inside
        set(value) {
            val color = when (value) {
                SimpleLabelDrawer.DrawLocation.Inside -> Color.White
                SimpleLabelDrawer.DrawLocation.Outside, SimpleLabelDrawer.DrawLocation.XAxis -> Color.Black
            }
            labelDrawer = SimpleLabelDrawer(drawLocation = value, labelTextColor = color)
            field = value
        }

    internal fun addBar() {
        val newBars = bars.toMutableList().apply {
            add(
                BarChartData.Bar(
                    label = "Bar ${bars.size + 1}",
                    value = randomValue(),
                    color = randomColor()
                )
            )
        }.toList()
        barChartData = barChartData.copy(bars = newBars, maxBarValue = newBars.maxOf { it.value })
    }

    internal fun removeBar() {
        barChartData = barChartData.copy(bars = bars.toMutableList().apply {
            val lastBar = bars.last()
            colors.add(lastBar.color)
            remove(lastBar)
        })
    }

    private fun randomValue(): Float = Random.Default.nextInt(25, 125).toFloat()
    private fun randomColor(): Color {
        val idx = Random.Default.nextInt(colors.size)
        return colors.removeAt(idx)
    }
}
