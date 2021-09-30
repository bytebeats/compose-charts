package me.bytebeats.views.charts.app.ui

import androidx.compose.animation.Crossfade
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import me.bytebeats.views.charts.app.ui.screen.HomeScreen
import me.bytebeats.views.charts.app.ui.screen.bar.BarChartScreen
import me.bytebeats.views.charts.app.ui.screen.line.LineChartScreen
import me.bytebeats.views.charts.app.ui.screen.pie.PieChartScreen
import me.bytebeats.views.charts.app.ui.theme.ComposeChartsTheme

/**
 * Created by bytebeats on 2021/9/30 : 16:24
 * E-mail: happychinapc@gmail.com
 * Quote: Peasant. Educated. Worker
 */

@Composable
fun ComposeCharts() {
    ComposeChartsTheme {
        ComposeChartsContent()
    }
}

@Composable
private fun ComposeChartsContent() {
    Crossfade(targetState = ScreenRouter.currentScreen) { screen ->
        Surface(color = MaterialTheme.colors.background) {
            when (screen) {
                Screen.Pie -> PieChartScreen()
                Screen.Line -> LineChartScreen()
                Screen.Bar -> BarChartScreen()
                else -> HomeScreen()
            }
        }
    }
}