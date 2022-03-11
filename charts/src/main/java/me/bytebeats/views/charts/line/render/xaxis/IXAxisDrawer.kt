package me.bytebeats.views.charts.line.render.xaxis

import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.Canvas
import androidx.compose.ui.graphics.drawscope.DrawScope

/**
 * Created by bytebeats on 2021/9/24 : 20:45
 * E-mail: happychinapc@gmail.com
 * Quote: Peasant. Educated. Worker
 */
interface IXAxisDrawer {
    fun requireHeight(drawScope: DrawScope): Float

    fun drawXAxisLine(drawScope: DrawScope, canvas: Canvas, drawableArea: Rect)

    fun drawXAxisLabels(
        drawScope: DrawScope,
        canvas: Canvas,
        drawableArea: Rect,
        labels: List<*>
    )
}