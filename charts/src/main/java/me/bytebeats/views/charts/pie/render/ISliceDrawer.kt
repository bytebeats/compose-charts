package me.bytebeats.views.charts.pie.render

import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Canvas
import androidx.compose.ui.graphics.drawscope.DrawScope
import me.bytebeats.views.charts.pie.PieChartData

/**
 * Created by bytebeats on 2021/9/24 : 14:30
 * E-mail: happychinapc@gmail.com
 * Quote: Peasant. Educated. Worker
 */
interface ISliceDrawer {


    /**
     * Draw slice
     * @param drawScope the scope to draw in
     * @param canvas the canvas to draw on
     * @param area the area to draw
     * @param startAngle the start angle to draw a slice
     * @param sweepAngle the sweep angle to draw a slice
     * @param slice the slice data to draw
     */
    fun drawSlice(
        drawScope: DrawScope,
        canvas: Canvas,
        area: Size,
        startAngle: Float,
        sweepAngle: Float,
        slice: PieChartData.Slice
    )
}
