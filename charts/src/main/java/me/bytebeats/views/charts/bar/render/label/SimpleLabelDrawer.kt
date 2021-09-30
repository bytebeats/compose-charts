package me.bytebeats.views.charts.bar.render.label

import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.Canvas
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import me.bytebeats.views.charts.toLegacyInt

/**
 * Created by bytebeats on 2021/9/25 : 14:01
 * E-mail: happychinapc@gmail.com
 * Quote: Peasant. Educated. Worker
 */
data class SimpleLabelDrawer(
    val drawLocation: DrawLocation = DrawLocation.Inside,
    val labelTextSize: TextUnit = 12.sp,
    val labelTextColor: Color = Color.Black
) : ILabelDrawer {
    private val mLabelTextArea: Float? = null
    private val mPaint by lazy {
        android.graphics.Paint().apply {
            textAlign = android.graphics.Paint.Align.CENTER
            color = labelTextColor.toLegacyInt()
        }
    }

    override fun requiredAboveBarHeight(drawScope: DrawScope): Float = when (drawLocation) {
        DrawLocation.Outside -> 3F / 2F * labelTextHeight(drawScope)
        else -> 0F
    }

    override fun requiredXAxisHeight(drawScope: DrawScope): Float = when (drawLocation) {
        DrawLocation.XAxis -> labelTextHeight(drawScope)
        else -> 0F
    }

    override fun drawLabel(
        drawScope: DrawScope,
        canvas: Canvas,
        label: String,
        barArea: Rect,
        xAxisArea: Rect
    ) {
        with(drawScope) {
            val xCenter = barArea.left + barArea.width / 2
            val yCenter = when (drawLocation) {
                DrawLocation.Inside -> (barArea.top + barArea.bottom) / 2
                DrawLocation.Outside -> barArea.top - labelTextSize.toPx() / 2
                DrawLocation.XAxis -> barArea.bottom + labelTextHeight(drawScope)
            }
            canvas.nativeCanvas.drawText(label, xCenter, yCenter, paint(drawScope))
        }
    }

    private fun labelTextHeight(drawScope: DrawScope): Float = with(drawScope) {
        mLabelTextArea ?: (1.5F * labelTextSize.toPx())
    }

    private fun paint(drawScope: DrawScope): android.graphics.Paint = with(drawScope) {
        mPaint.apply { textSize = labelTextSize.toPx() }
    }

    enum class DrawLocation {
        Inside, Outside, XAxis;
    }
}