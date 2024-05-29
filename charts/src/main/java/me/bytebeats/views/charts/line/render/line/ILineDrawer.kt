package me.bytebeats.views.charts.line.render.line

import androidx.compose.ui.graphics.Canvas
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.DrawScope

/**
 * Created by bytebeats on 2021/9/25 : 12:45
 * E-mail: happychinapc@gmail.com
 * Quote: Peasant. Educated. Worker
 */
interface ILineDrawer {

    /**
     * Draw line
     *
     * @param drawScope the scope to draw in
     * @param canvas the canvas to draw on
     * @param linePath the line path to draw
     */
    fun drawLine(
        drawScope: DrawScope,
        canvas: Canvas,
        linePath: Path
    )
}
