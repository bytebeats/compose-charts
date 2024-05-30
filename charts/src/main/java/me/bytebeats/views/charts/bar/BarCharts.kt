package me.bytebeats.views.charts.bar

import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.unit.dp
import me.bytebeats.views.charts.bar.render.label.ILabelDrawer
import me.bytebeats.views.charts.bar.render.xaxis.IXAxisDrawer
import me.bytebeats.views.charts.util.FLOAT_10
import me.bytebeats.views.charts.util.FLOAT_100

/**
 * Created by bytebeats on 2021/9/25 : 13:57
 * E-mail: happychinapc@gmail.com
 * Quote: Peasant. Educated. Worker
 */

internal fun axisAreas(
    drawScope: DrawScope,
    totalSize: Size,
    xAxisDrawer: IXAxisDrawer,
    labelDrawer: ILabelDrawer
): Pair<Rect, Rect> {
    with(drawScope) {

        val yAxisTop = labelDrawer.requiredAboveBarHeight(drawScope)
        val yAxisRight = 50.dp.toPx().coerceAtMost(size.width * FLOAT_10 / FLOAT_100)
        val xAxisRight = totalSize.width
        val xAxisTop = totalSize.height - xAxisDrawer.requiredHeight(drawScope)

        return Rect(
            left = yAxisRight,
            top = xAxisTop,
            right = xAxisRight,
            bottom = totalSize.height
        ) to Rect(
            left = 0F,
            top = yAxisTop,
            right = yAxisRight,
            bottom = xAxisTop
        )
    }
}

internal fun barDrawableArea(xAxisArea: Rect): Rect =
    Rect(
        left = xAxisArea.left,
        top = 0F,
        right = xAxisArea.right,
        bottom = xAxisArea.top
    )

internal fun BarChartData.forEachWithArea(
    drawScope: DrawScope,
    barDrawableArea: Rect,
    progress: Float,
    labelDrawer: ILabelDrawer,
    block: (barArea: Rect, bar: BarChartData.Bar) -> Unit
) {
    val barCount = bars.size
    val widthOfBarArea = barDrawableArea.width / barCount
    val offsetOfBar = widthOfBarArea * 0.2F

    bars.forEachIndexed { index, bar ->
        val left = barDrawableArea.left + index * widthOfBarArea
        val height = barDrawableArea.height
        val barHeight = (height - labelDrawer.requiredAboveBarHeight(drawScope)) * progress
        val barArea = Rect(
            left = left + offsetOfBar,
            top = barDrawableArea.bottom - bar.value / maxBarValue * barHeight,
            right = left + widthOfBarArea - offsetOfBar,
            bottom = barDrawableArea.bottom
        )
        block(barArea, bar)
    }
}
