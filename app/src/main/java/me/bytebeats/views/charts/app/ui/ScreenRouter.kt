package me.bytebeats.views.charts.app.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

/**
 * Created by bytebeats on 2021/9/30 : 11:39
 * E-mail: happychinapc@gmail.com
 * Quote: Peasant. Educated. Worker
 */
object ScreenRouter {
    var currentScreen by mutableStateOf(Screen.Home)

    /**
     * Navigate
     *
     * @param screen
     */
    fun navigate(screen: Screen) {
        currentScreen = screen
    }

    /**
     * Navigate home
     */
    fun navigateHome() {
        currentScreen = Screen.Home
    }
}
