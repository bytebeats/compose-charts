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

    /**
     * Required height
     *
     * @param drawScope the draw scope to require height
     * @return required height
     */
    fun requiredHeight(drawScope: DrawScope): Float

    /**
     * Draw x axis line
     *
     * @param drawScope the scope to draw
     * @param canvas the canvas to draw on
     * @param drawableArea the area to draw a drawable
     */
    fun drawXAxisLine(
        drawScope: DrawScope,
        canvas: Canvas,
        drawableArea: Rect
    )
}
