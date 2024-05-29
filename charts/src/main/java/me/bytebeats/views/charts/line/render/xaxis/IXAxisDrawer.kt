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

    /**
     * require height
     *
     * @param drawScope the scope to draw in
     */
    fun requireHeight(drawScope: DrawScope): Float

    /**
     * Draw x axis line
     *
     * @param drawScope the scope to draw in
     * @param canvas the canvas to draw on
     * @param drawableArea the area to draw a drawable
     */
    fun drawXAxisLine(
        drawScope: DrawScope,
        canvas: Canvas,
        drawableArea: Rect
    )

    /**
     * Draw labels in x axis
     *
     * @param drawScope the scope to draw in
     * @param canvas the canvas to draw on
     * @param drawableArea the area to draw
     * @param labels the labels to draw on axis
     */
    fun drawXAxisLabels(
        drawScope: DrawScope,
        canvas: Canvas,
        drawableArea: Rect,
        labels: List<*>
    )
}
