package me.bytebeats.views.charts.pie

import androidx.compose.ui.graphics.Color

/**
 * Created by bytebeats on 2021/9/24 : 14:32
 * E-mail: happychinapc@gmail.com
 * Quote: Peasant. Educated. Worker
 */
data class PieChartData(val slices: List<Slice>) {
    internal val totalLength: Float
        get() {
            return slices.map { it.value }.sum()
        }

    data class Slice(val value: Float, val color: Color)
}
