package me.bytebeats.views.charts.bar.render.yaxis

import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.Canvas
import androidx.compose.ui.graphics.drawscope.DrawScope

/**
 * Created by bytebeats on 2021/9/25 : 14:26
 * E-mail: happychinapc@gmail.com
 * Quote: Peasant. Educated. Worker
 */
interface IYAxisDrawer {

    /**
     * Draw axis line
     *
     * @param drawScope the scope to draw
     * @param canvas the canvas to draw on
     * @param drawableArea the area to draw a drawable
     */
    fun drawAxisLine(
        drawScope: DrawScope,
        canvas: Canvas,
        drawableArea: Rect
    )


    /**
     * Draw axis labels
     *
     * @param drawScope the scope to draw
     * @param canvas the canvas to draw on
     * @param drawableArea the drawable area
     * @param minValue the min value of the y axis data
     * @param maxValue the max value of the y axis data
     */
    fun drawAxisLabels(
        drawScope: DrawScope,
        canvas: Canvas,
        drawableArea: Rect,
        minValue: Float,
        maxValue: Float
    )
}
