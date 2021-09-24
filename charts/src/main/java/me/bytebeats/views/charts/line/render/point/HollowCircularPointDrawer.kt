package me.bytebeats.views.charts.line.render.point

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Canvas
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.PaintingStyle
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * Created by bytebeats on 2021/9/24 : 20:38
 * E-mail: happychinapc@gmail.com
 * Quote: Peasant. Educated. Worker
 */
data class HollowCircularPointDrawer(
    val diameter: Dp = 8.dp,
    val lineThickness: Dp = 2.dp,
    val color: Color = Color.Blue
) : IPointDrawer {

    private val mPaint by lazy {
        Paint().apply {
            color = this@HollowCircularPointDrawer.color
            style = PaintingStyle.Stroke
            isAntiAlias = true
        }
    }

    override fun drawPoint(drawScope: DrawScope, canvas: Canvas, center: Offset) {
        with(drawScope as Density) {
            canvas.drawCircle(
                center,
                diameter.toPx().div(2F),
                mPaint.apply { strokeWidth = lineThickness.toPx() })
        }
    }
}
