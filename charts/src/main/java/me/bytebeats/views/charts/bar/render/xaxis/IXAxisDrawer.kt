package me.bytebeats.views.charts.bar.render.xaxis

import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.Canvas
import androidx.compose.ui.graphics.drawscope.DrawScope

/**
 * Created by bytebeats on 2021/9/25 : 14:16
 * E-mail: happychinapc@gmail.com
 * Quote: Peasant. Educated. Worker
 */
interface IXAxisDrawer {
    fun requiredHeight(drawScope: DrawScope): Float
    fun drawXAxisLine(
        drawScope: DrawScope,
        canvas: Canvas,
        drawableArea: Rect
    )
}
