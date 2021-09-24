package me.bytebeats.views.charts

import androidx.compose.ui.graphics.Color

/**
 * Created by bytebeats on 2021/9/24 : 10:51
 * E-mail: happychinapc@gmail.com
 * Quote: Peasant. Educated. Worker
 */


fun Color.toLegacyInt(): Int {
    return android.graphics.Color.argb(
        (alpha * 255F + .5F).toInt(),
        (red * 255F + .5F).toInt(),
        (green * 255F + .5F).toInt(),
        (blue * 255F + .5F).toInt()
    )
}