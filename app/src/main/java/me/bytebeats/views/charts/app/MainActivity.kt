package me.bytebeats.views.charts.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import me.bytebeats.views.charts.app.ui.ComposeCharts

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeCharts()
        }
    }
}

@Preview
@Composable
private fun DefaultPreview() {
    ComposeCharts()
}
