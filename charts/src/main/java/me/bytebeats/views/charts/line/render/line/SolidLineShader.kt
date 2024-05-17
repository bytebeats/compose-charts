package me.bytebeats.views.charts.line.render.line

import androidx.compose.ui.graphics.Canvas
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.DrawScope

/**
 * Created by bytebeats on 2021/9/25 : 12:51
 * E-mail: happychinapc@gmail.com
 * Quote: Peasant. Educated. Worker
 */
data class SolidLineShader(
    val color: Color = Color.Blue
) : ILineShader {
    override fun fillLine(
        drawScope: DrawScope,
        canvas: Canvas,
        fillPath: Path
    ) {
        drawScope.drawPath(
            path = fillPath,
            color = color
        )
    }
}
