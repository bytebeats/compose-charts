package me.bytebeats.views.charts.line.render.line

import androidx.compose.ui.graphics.Canvas
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.DrawScope

/**
 * Created by bytebeats on 2021/9/25 : 12:49
 * E-mail: happychinapc@gmail.com
 * Quote: Peasant. Educated. Worker
 */
interface ILineShader {

    /**
     * fill slice
     *
     * @param drawScope the scope to draw in
     * @param canvas the canvas to draw on
     * @param fillPath the path to fill
     */
    fun fillLine(
        drawScope: DrawScope,
        canvas: Canvas,
        fillPath: Path
    )
}
