package me.bytebeats.views.charts.line.render.point

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Canvas
import androidx.compose.ui.graphics.drawscope.DrawScope

/**
 * Created by bytebeats on 2021/9/24 : 20:24
 * E-mail: happychinapc@gmail.com
 * Quote: Peasant. Educated. Worker
 */
object EmptyPointDrawer : IPointDrawer {
    override fun drawPoint(
        drawScope: DrawScope,
        canvas: Canvas,
        center: Offset
    ) {
        //empty point, we do nothing here.
    }
}
