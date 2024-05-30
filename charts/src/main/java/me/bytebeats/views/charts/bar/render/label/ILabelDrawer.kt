package me.bytebeats.views.charts.bar.render.label

import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.Canvas
import androidx.compose.ui.graphics.drawscope.DrawScope

/**
 * Created by bytebeats on 2021/9/25 : 13:59
 * E-mail: happychinapc@gmail.com
 * Quote: Peasant. Educated. Worker
 */
interface ILabelDrawer {


    /**
     * Required x axis height
     *
     * @param drawScope the scope to draw in
     * @return required height
     */
    fun requiredXAxisHeight(drawScope: DrawScope): Float = 0F


    /**
     * Required above bar height
     *
     * @param drawScope the scope to draw in
     * @return required height
     */
    fun requiredAboveBarHeight(drawScope: DrawScope): Float = 0F

    /**
     * Draw label
     *
     * @param drawScope the scope to draw in
     * @param canvas the canvas to draw on
     * @param label the label to draw on the axis
     * @param barArea the area to draw a bar
     * @param xAxisArea the x axis area to draw
     */
    fun drawLabel(
        drawScope: DrawScope,
        canvas: Canvas,
        label: Any?,
        barArea: Rect,
        xAxisArea: Rect
    )
}
