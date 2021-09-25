package me.bytebeats.views.charts.bar.render.bar

import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.Canvas
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.drawscope.DrawScope
import me.bytebeats.views.charts.bar.BarChartData

/**
 * Created by bytebeats on 2021/9/25 : 15:54
 * E-mail: happychinapc@gmail.com
 * Quote: Peasant. Educated. Worker
 */
class SimpleBarDrawer : IBarDrawer {
    private val mBarPaint by lazy { Paint().apply { isAntiAlias = true } }

    override fun drawBar(
        drawScope: DrawScope,
        canvas: Canvas,
        barArea: Rect,
        bar: BarChartData.Bar
    ) {
        canvas.drawRect(barArea, mBarPaint.apply { color = bar.color })
    }
}
