package me.bytebeats.views.charts.bar

import androidx.compose.ui.graphics.Color

/**
 * Created by bytebeats on 2021/9/25 : 13:52
 * E-mail: happychinapc@gmail.com
 * Quote: Peasant. Educated. Worker
 */
data class BarChartData(
    val bars: List<Bar>,
    val padBy: Float = 10F,
    val startAtZero: Boolean = true
) {

    init {
        require(padBy in 0F..100F) {
            "padBy must be between 0F and 100F, included"
        }
    }

    private val yMinMaxValues: Pair<Float, Float>
        get() {
            val minValue = bars.minOf { it.value }
            val maxValue = bars.maxOf { it.value }
            return minValue to maxValue
        }

    internal val maxY: Float
        get() = yMinMaxValues.second + (yMinMaxValues.second - yMinMaxValues.first) * padBy / 100F
    internal val minY: Float
        get() = if (startAtZero) 0F else yMinMaxValues.first - (yMinMaxValues.second - yMinMaxValues.first) * padBy / 100F

    val maxBarValue: Float
        get() = bars.maxOf { it.value }

    data class Bar(val value: Float, val color: Color, val label: String)
}
