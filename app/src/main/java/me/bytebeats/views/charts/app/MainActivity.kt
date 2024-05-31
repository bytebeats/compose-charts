package me.bytebeats.views.charts.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import me.bytebeats.views.charts.app.ui.ComposeCharts


/**
 * Main activity
 */
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeCharts()
        }
    }
}
