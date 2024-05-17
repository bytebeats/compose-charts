package me.bytebeats.views.charts.line.render.line

import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * Created by bytebeats on 2021/9/25 : 12:46
 * E-mail: happychinapc@gmail.com
 * Quote: Peasant. Educated. Worker
 */
data class SolidLineDrawer(
    val thickness: Dp = 3.dp,
    val color: Color = Color.Cyan
) : ILineDrawer {
    private val mPaint by lazy {
        Paint().apply {
            color = this@SolidLineDrawer.color
            style = PaintingStyle.Stroke
            isAntiAlias = true
        }
    }

    override fun drawLine(
        drawScope: DrawScope,
        canvas: Canvas,
        linePath: Path
    ) {
        val lineThickness = with(drawScope) {
            thickness.toPx()
        }
        canvas.drawPath(
            path = linePath,
            paint = mPaint.apply { strokeWidth = lineThickness }
        )
    }
}
