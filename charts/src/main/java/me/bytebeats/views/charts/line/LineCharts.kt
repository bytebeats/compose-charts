package me.bytebeats.views.charts.line

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.dp
import me.bytebeats.views.charts.util.FLOAT_10
import me.bytebeats.views.charts.util.FLOAT_100

/**
 * Created by bytebeats on 2021/9/24 : 19:26
 * E-mail: happychinapc@gmail.com
 * Quote: Peasant. Educated. Worker
 */

internal fun computeDrawableArea(
    xAxisDrawableArea: Rect,
    yAxisDrawableArea: Rect,
    size: Size,
    offset: Float
): Rect {
    val horizontalOffset = xAxisDrawableArea.width * offset / FLOAT_100
    return Rect(
        left = yAxisDrawableArea.right + horizontalOffset,
        top = 0F,
        bottom = xAxisDrawableArea.top,
        right = size.width - horizontalOffset
    )
}

internal fun computeXAxisDrawableArea(
    yAxisWidth: Float,
    labelHeight: Float,
    size: Size
): Rect {
    val top = size.height - labelHeight
    return Rect(
        left = yAxisWidth,
        top = top,
        right = size.width,
        bottom = size.height
    )
}

internal fun computeXAxisLabelsDrawableArea(
    xAxisDrawableArea: Rect,
    offset: Float
): Rect {
    val horizontalOffset = xAxisDrawableArea.width * offset / FLOAT_100
    return Rect(
        left = xAxisDrawableArea.left + horizontalOffset,
        top = xAxisDrawableArea.top,
        right = xAxisDrawableArea.right - horizontalOffset,
        bottom = xAxisDrawableArea.bottom
    )
}

internal fun Density.computeYAxisDrawableArea(
    xAxisLabelSize: Float,
    size: Size
): Rect {
    val right =
        50.dp.toPx().coerceAtMost(size.width * FLOAT_10 / FLOAT_100) // 50dp or 10% of chart view width
    return Rect(
        left = 0F,
        top = 0F,
        right = right,
        bottom = size.height - xAxisLabelSize
    )
}

internal fun computePointLocation(
    drawableArea: Rect,
    lineChartData: LineChartData,
    point: LineChartData.Point,
    index: Int
): Offset {
    val dx = index.toFloat() / (lineChartData.points.size - 1)
    val dy = (point.value - lineChartData.minY) / lineChartData.yRange
    return Offset(
        x = dx * drawableArea.width + drawableArea.left,
        y = drawableArea.height - dy * drawableArea.height
    )
}

internal fun withProgress(
    index: Int,
    lineChartData: LineChartData,
    transitionProgress: Float,
    progressListener: (progress: Float) -> Unit
) {
    val size = lineChartData.points.size
    val toIndex = (size * transitionProgress).toInt() + 1
    if (index == toIndex) {
        val sizeF = lineChartData.points.size.toFloat()
        val divider = 1F / sizeF
        val down = (index - 1) * divider
        progressListener((transitionProgress - down) / divider)
    } else if (index < toIndex) {
        progressListener(1F)
    }
}

internal fun computeLinePath(
    drawableArea: Rect,
    lineChartData: LineChartData,
    transitionProgress: Float
): Path = Path().apply {
    var prePointLocation: Offset? = null
    lineChartData.points.forEachIndexed { index, point ->
        withProgress(index, lineChartData, transitionProgress) { progress ->
            val pointLocation = computePointLocation(drawableArea, lineChartData, point, index)
            if (index == 0) {
                moveTo(pointLocation.x, pointLocation.y)
            } else {
                if (progress <= 1F) {
                    val preX = prePointLocation?.x ?: 0F
                    val preY = prePointLocation?.y ?: 0F
                    val tx = (pointLocation.x - preX) * progress + preX
                    val ty = (pointLocation.y - preY) * progress + preY
                    lineTo(tx, ty)
                } else {
                    lineTo(pointLocation.x, pointLocation.y)
                }
            }
            prePointLocation = pointLocation
        }
    }
}

internal fun computeFillPath(
    drawableArea: Rect,
    lineChartData: LineChartData,
    transitionProgress: Float
): Path = Path().apply {
    moveTo(drawableArea.left, drawableArea.bottom)
    var prePointX: Float? = null
    var prePointLocation: Offset? = null
    lineChartData.points.forEachIndexed { index, point ->
        withProgress(index, lineChartData, transitionProgress) { progress ->
            val pointLocation = computePointLocation(drawableArea, lineChartData, point, index)
            if (index == 0) {
                lineTo(drawableArea.left, pointLocation.y)
                lineTo(pointLocation.x, pointLocation.y)
            } else {
                prePointX = if (progress <= 1F) {
                    val preX = prePointLocation?.x ?: 0F
                    val preY = prePointLocation?.y ?: 0F
                    val tx = (pointLocation.x - preX) * progress + preX
                    val ty = (pointLocation.y - preY) * progress + preY
                    lineTo(tx, ty)
                    tx
                } else {
                    lineTo(pointLocation.x, pointLocation.y)
                    pointLocation.x
                }
            }
            prePointLocation = pointLocation
        }
    }
    prePointX?.let {
        lineTo(it, drawableArea.bottom)
        lineTo(drawableArea.left, drawableArea.bottom)
    } ?: lineTo(drawableArea.left, drawableArea.bottom)
}
