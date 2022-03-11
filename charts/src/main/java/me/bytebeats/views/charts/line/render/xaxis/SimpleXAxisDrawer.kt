package me.bytebeats.views.charts.line.render.xaxis

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.Canvas
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.PaintingStyle
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import me.bytebeats.views.charts.AxisLabelFormatter
import me.bytebeats.views.charts.toLegacyInt

/**
 * Created by bytebeats on 2021/9/24 : 20:50
 * E-mail: happychinapc@gmail.com
 * Quote: Peasant. Educated. Worker
 */
data class SimpleXAxisDrawer(
    val labelTextSize: TextUnit = 12.sp,
    val labelTextColor: Color = Color.Black,
    val drawLabelEvery: Int = 1,// draw label text every $drawLabelEvery, like 1, 2, 3 and so on.
    val axisLineThickness: Dp = 1.dp,
    val axisLineColor: Color = Color.Black,
    val axisLabelFormatter: AxisLabelFormatter = { value -> "$value" }
) : IXAxisDrawer {
    private val mAxisLinePaint by lazy {
        Paint().apply {
            isAntiAlias = true
            color = axisLineColor
            style = PaintingStyle.Stroke
        }
    }

    private val mTextPaint by lazy {
        android.graphics.Paint().apply {
            isAntiAlias = true
            color = labelTextColor.toLegacyInt()
        }
    }

    override fun requireHeight(drawScope: DrawScope): Float = with(drawScope) {
        1.5F * (labelTextSize.toPx() + axisLineThickness.toPx())
    }

    override fun drawXAxisLine(drawScope: DrawScope, canvas: Canvas, drawableArea: Rect) {
        with(drawScope) {
            val lineThickness = axisLineThickness.toPx()
            val y = drawableArea.top + lineThickness / 2F

            canvas.drawLine(
                p1 = Offset(x = drawableArea.left, y = y),
                p2 = Offset(x = drawableArea.right, y = y),
                paint = mAxisLinePaint.apply { strokeWidth = lineThickness })
        }
    }

    override fun drawXAxisLabels(
        drawScope: DrawScope,
        canvas: Canvas,
        drawableArea: Rect,
        labels: List<*>
    ) {
        with(drawScope) {
            val labelPaint = mTextPaint.apply {
                textSize = labelTextSize.toPx()
                textAlign = android.graphics.Paint.Align.CENTER
            }
            val labelIncrements = drawableArea.width / (labels.size - 1)
            labels.forEachIndexed { index, label ->
                if (index.rem(drawLabelEvery) == 0) {
                    val labelValue = axisLabelFormatter(label)
                    val x = drawableArea.left + labelIncrements * index
                    val y = drawableArea.bottom
                    canvas.nativeCanvas.drawText(labelValue, x, y, labelPaint)
                }
            }
        }
    }
}
