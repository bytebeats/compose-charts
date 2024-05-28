package me.bytebeats.views.charts.line

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.AnimationSpec
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import me.bytebeats.views.charts.line.render.line.EmptyLineShader
import me.bytebeats.views.charts.line.render.line.ILineDrawer
import me.bytebeats.views.charts.line.render.line.ILineShader
import me.bytebeats.views.charts.line.render.line.SolidLineDrawer
import me.bytebeats.views.charts.line.render.point.FilledCircularPointDrawer
import me.bytebeats.views.charts.line.render.point.IPointDrawer
import me.bytebeats.views.charts.line.render.xaxis.IXAxisDrawer
import me.bytebeats.views.charts.line.render.xaxis.SimpleXAxisDrawer
import me.bytebeats.views.charts.line.render.yaxis.IYAxisDrawer
import me.bytebeats.views.charts.line.render.yaxis.SimpleYAxisDrawer
import me.bytebeats.views.charts.simpleChartAnimation

/**
 * Created by bytebeats on 2021/9/25 : 12:55
 * E-mail: happychinapc@gmail.com
 * Quote: Peasant. Educated. Worker
 */

@Composable
fun LineChart(
    lineChartData: LineChartData,
    modifier: Modifier = Modifier,
    animation: AnimationSpec<Float> = simpleChartAnimation(),
    pointDrawer: IPointDrawer = FilledCircularPointDrawer(),
    lineDrawer: ILineDrawer = SolidLineDrawer(),
    lineShader: ILineShader = EmptyLineShader,
    xAxisDrawer: IXAxisDrawer = SimpleXAxisDrawer(),
    yAxisDrawer: IYAxisDrawer = SimpleYAxisDrawer(),
    horizontalOffset: Float = 5F,
) {
    check(horizontalOffset in 0F..25F) {
        "Horizontal Offset is the percentage offset from side, and must be between 0 and 25, included."
    }
    val transitionAnimation = remember(lineChartData.points) {
        Animatable(initialValue = 0F)
    }

    LaunchedEffect(lineChartData.points) {
        transitionAnimation.snapTo(0F)
        transitionAnimation.animateTo(1F, animationSpec = animation)
    }

    Canvas(
        modifier = modifier.fillMaxSize()
    ) {
        drawIntoCanvas { canvas ->
            val yAxisDrawableArea = computeYAxisDrawableArea(
                xAxisLabelSize = xAxisDrawer.requireHeight(this),
                size = size
            )
            val xAxisDrawableArea = computeXAxisDrawableArea(
                yAxisWidth = yAxisDrawableArea.width,
                labelHeight = xAxisDrawer.requireHeight(this),
                size = size
            )
            val xAxisLabelsDrawableArea = computeXAxisLabelsDrawableArea(
                xAxisDrawableArea = xAxisDrawableArea,
                offset = horizontalOffset
            )

            val chartDrawableArea = computeDrawableArea(
                xAxisDrawableArea = xAxisDrawableArea,
                yAxisDrawableArea = yAxisDrawableArea,
                size = size,
                offset = horizontalOffset
            )

            lineDrawer.drawLine(
                drawScope = this,
                canvas = canvas,
                linePath = computeLinePath(
                    drawableArea = chartDrawableArea,
                    lineChartData = lineChartData,
                    transitionProgress = transitionAnimation.value
                )
            )
            lineShader.fillLine(
                drawScope = this,
                canvas = canvas,
                fillPath = computeFillPath(
                    drawableArea = chartDrawableArea,
                    lineChartData = lineChartData,
                    transitionProgress = transitionAnimation.value
                )
            )
            lineChartData.points.forEachIndexed { index, point ->
                withProgress(
                    index = index,
                    lineChartData = lineChartData,
                    transitionProgress = transitionAnimation.value
                ) {
                    pointDrawer.drawPoint(
                        drawScope = this,
                        canvas = canvas,
                        center = computePointLocation(
                            drawableArea = chartDrawableArea,
                            lineChartData = lineChartData,
                            point = point,
                            index = index
                        )
                    )
                }
            }

            xAxisDrawer.drawXAxisLine(
                drawScope = this,
                drawableArea = xAxisDrawableArea,
                canvas = canvas
            )
            xAxisDrawer.drawXAxisLabels(
                drawScope = this,
                canvas = canvas,
                drawableArea = xAxisLabelsDrawableArea,
                labels = lineChartData.points.map { it.label })
            yAxisDrawer.drawAxisLine(
                drawScope = this,
                drawableArea = yAxisDrawableArea,
                canvas = canvas
            )
            yAxisDrawer.drawAxisLabels(
                drawScope = this,
                canvas = canvas,
                drawableArea = yAxisDrawableArea,
                minValue = lineChartData.minY,
                maxValue = lineChartData.maxY
            )
        }
    }
}
