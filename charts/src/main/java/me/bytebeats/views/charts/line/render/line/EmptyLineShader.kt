package me.bytebeats.views.charts.line.render.line

import androidx.compose.ui.graphics.Canvas
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.DrawScope

/**
 * Created by bytebeats on 2021/9/25 : 12:50
 * E-mail: happychinapc@gmail.com
 * Quote: Peasant. Educated. Worker
 */
object EmptyLineShader : ILineShader {
    override fun fillLine(
        drawScope: DrawScope,
        canvas: Canvas,
        fillPath: Path
    ) {
        // do nothing here
    }
}
