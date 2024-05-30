package me.bytebeats.views.charts.line.render.point

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Canvas
import androidx.compose.ui.graphics.drawscope.DrawScope

/**
 * Created by bytebeats on 2021/9/24 : 20:22
 * E-mail: happychinapc@gmail.com
 * Quote: Peasant. Educated. Worker
 */
interface IPointDrawer {

    /**
     * Draw point
     *
     * @param drawScope the scope to draw in
     * @param canvas the canvas to draw on
     * @param center the center point to draw a point
     */
    fun drawPoint(
        drawScope: DrawScope,
        canvas: Canvas,
        center: Offset
    )
}
