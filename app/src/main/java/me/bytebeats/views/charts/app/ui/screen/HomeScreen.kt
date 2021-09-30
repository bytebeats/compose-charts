package me.bytebeats.views.charts.app.ui.screen

import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import me.bytebeats.views.charts.app.ui.Screen
import me.bytebeats.views.charts.app.ui.ScreenRouter
import me.bytebeats.views.charts.app.ui.theme.Margins

/**
 * Created by bytebeats on 2021/9/30 : 11:43
 * E-mail: happychinapc@gmail.com
 * Quote: Peasant. Educated. Worker
 */

@Composable
fun HomeScreen() {
    Scaffold(topBar = {
        TopAppBar(title = { Text(text = "Compose Charts") })
    }) {
        HomeScreenContent()
    }
}

@Composable
private fun HomeScreenContent() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        ChartScreenSelector(text = "Pie Chart", nextScreen = Screen.Pie)
        ChartScreenSelector(text = "Line Chart", nextScreen = Screen.Line)
        ChartScreenSelector(text = "Bar Chart", nextScreen = Screen.Bar)
    }
}

@Composable
private fun ChartScreenSelector(text: String, nextScreen: Screen) {
    Row(modifier = Modifier.padding(horizontal = Margins.horizontal, vertical = Margins.vertical)) {
        TextButton(onClick = { ScreenRouter.navigate(nextScreen) }) {
            Text(text = text)
        }
    }
}

@Preview
@Composable
private fun HomeScreenPreview() = HomeScreen()