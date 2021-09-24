package me.bytebeats.views.charts.pie

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.AnimationSpec
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.tooling.preview.Preview
import me.bytebeats.views.charts.pie.render.ISliceDrawer
import me.bytebeats.views.charts.pie.render.SimpleSliceDrawer
import me.bytebeats.views.charts.simpleChartAnimation

/**
 * Created by bytebeats on 2021/9/24 : 15:34
 * E-mail: happychinapc@gmail.com
 * Quote: Peasant. Educated. Worker
 */

@Composable
fun PieChart(
    pieChartData: PieChartData,
    modifier: Modifier = Modifier,
    animation: AnimationSpec<Float> = simpleChartAnimation(),
    sliceDrawer: ISliceDrawer = SimpleSliceDrawer()
) {
    val transitionProgress = remember(pieChartData.slices) { Animatable(initialValue = 0F) }

    LaunchedEffect(pieChartData.slices) {
        transitionProgress.animateTo(1F, animationSpec = animation)
    }

    DrawChart(
        pieChartData = pieChartData,
        modifier = modifier.fillMaxSize(),
        progress = transitionProgress.value,
        sliceDrawer = sliceDrawer
    )
}

@Composable
private fun DrawChart(
    pieChartData: PieChartData,
    modifier: Modifier,
    progress: Float,
    sliceDrawer: ISliceDrawer
) {
    val slices = pieChartData.slices

    Canvas(modifier) {
        drawIntoCanvas {
            var startArc = 0F
            slices.forEach { slice ->
                val arc = calculateAngle(
                    sliceLength = slice.value,
                    totalLength = pieChartData.totalLength,
                    progress = progress
                )
                sliceDrawer.drawSlice(
                    drawScope = this,
                    canvas = drawContext.canvas,
                    area = size,
                    startAngle = startArc,
                    sweepAngle = arc,
                    slice = slice
                )
                startArc += arc
            }
        }
    }
}

@Preview
@Composable
fun PreviewPieChart() = PieChart(
    pieChartData = PieChartData(
        slices = listOf(
            PieChartData.Slice(25F, Color.Red),
            PieChartData.Slice(45F, Color.Green),
            PieChartData.Slice(20F, Color.Blue)
        )
    )
)