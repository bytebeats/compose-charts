package me.bytebeats.views.charts.bar.render.bar

import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.Canvas
import androidx.compose.ui.graphics.drawscope.DrawScope
import me.bytebeats.views.charts.bar.BarChartData

/**
 * Created by bytebeats on 2021/9/25 : 15:53
 * E-mail: happychinapc@gmail.com
 * Quote: Peasant. Educated. Worker
 */
interface IBarDrawer {

    /**
     * Draw bar
     *
     * @param drawScope the scope to draw
     * @param canvas the Canvas to draw on
     * @param barArea the bar area to draw
     * @param bar the bar data
     */
    fun drawBar(
        drawScope: DrawScope,
        canvas: Canvas,
        barArea: Rect,
        bar: BarChartData.Bar
    )
}
