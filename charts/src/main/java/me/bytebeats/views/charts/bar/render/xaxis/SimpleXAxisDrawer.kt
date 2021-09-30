package me.bytebeats.views.charts.bar.render.xaxis

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.Canvas
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.PaintingStyle
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * Created by bytebeats on 2021/9/25 : 14:18
 * E-mail: happychinapc@gmail.com
 * Quote: Peasant. Educated. Worker
 */
data class SimpleXAxisDrawer(
    private val axisLineThickness: Dp = 1.dp,
    private val axisLineColor: Color = Color.Black
) : IXAxisDrawer {

    private val mPaint by lazy {
        Paint().apply {
            isAntiAlias = true
            color = axisLineColor
            style = PaintingStyle.Stroke
        }
    }

    override fun requiredHeight(drawScope: DrawScope): Float = with(drawScope) {
        1.5F * axisLineThickness.toPx()
    }

    override fun drawXAxisLine(drawScope: DrawScope, canvas: Canvas, drawableArea: Rect) {
        with(drawScope) {
            val lineThickness = axisLineThickness.toPx()
            val y = drawableArea.top + lineThickness / 2F
            canvas.drawLine(
                p1 = Offset(x = drawableArea.left, y = y),
                p2 = Offset(x = drawableArea.right, y = y),
                paint = mPaint.apply {
                    strokeWidth = lineThickness
                })
        }
    }
}
