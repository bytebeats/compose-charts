package me.bytebeats.views.charts.app.ui.screen.line

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import me.bytebeats.views.charts.line.LineChartData
import me.bytebeats.views.charts.line.LineChartData.Point
import me.bytebeats.views.charts.line.render.point.EmptyPointDrawer
import me.bytebeats.views.charts.line.render.point.FilledCircularPointDrawer
import me.bytebeats.views.charts.line.render.point.HollowCircularPointDrawer
import me.bytebeats.views.charts.line.render.point.IPointDrawer
import kotlin.random.Random

/**
 * Created by bytebeats on 2021/9/30 : 17:49
 * E-mail: happychinapc@gmail.com
 * Quote: Peasant. Educated. Worker
 */
class LineChartDataModel {
    var lineChartData by mutableStateOf(
        LineChartData(
            points = listOf(
                Point(randomYValue(), "Label 1"),
                Point(randomYValue(), "Label 2"),
                Point(randomYValue(), "Label 3"),
                Point(randomYValue(), "Label 4"),
                Point(randomYValue(), "Label 5"),
                Point(randomYValue(), "Label 6"),
                Point(randomYValue(), "Label 7")
            )
        )
    )

    var horizontalOffset by mutableFloatStateOf(5F)

    var pointDrawerType by mutableStateOf(PointDrawerType.Hollow)
    val pointDrawer: IPointDrawer
        get() {
            return when (pointDrawerType) {
                PointDrawerType.None -> EmptyPointDrawer
                PointDrawerType.Filled -> FilledCircularPointDrawer()
                PointDrawerType.Hollow -> HollowCircularPointDrawer()
            }
        }


    private fun randomYValue(): Float = Random.Default.nextInt(45, 145).toFloat()
}
