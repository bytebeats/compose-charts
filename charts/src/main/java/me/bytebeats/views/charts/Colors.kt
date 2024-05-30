package me.bytebeats.views.charts

import androidx.compose.ui.graphics.Color
import me.bytebeats.views.charts.util.FLOAT_0_5
import me.bytebeats.views.charts.util.FLOAT_255

/**
 * Created by bytebeats on 2021/9/24 : 10:51
 * E-mail: happychinapc@gmail.com
 * Quote: Peasant. Educated. Worker
 */

fun Color.toLegacyInt(): Int {
    return android.graphics.Color.argb(
        (alpha * FLOAT_255 + FLOAT_0_5).toInt(),
        (red * FLOAT_255 + FLOAT_0_5).toInt(),
        (green * FLOAT_255 + FLOAT_0_5).toInt(),
        (blue * FLOAT_255 + FLOAT_0_5).toInt()
    )
}
