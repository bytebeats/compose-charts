package me.bytebeats.views.charts.app.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen() {
  Scaffold(topBar = {
    TopAppBar(title = { Text(text = "Compose Charts") })
  }) { paddingValues ->
    HomeScreenContent(Modifier.padding(paddingValues))
  }
}

@Composable
private fun HomeScreenContent(modifier: Modifier) {
  Column(
    modifier = modifier.fillMaxSize(),
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
