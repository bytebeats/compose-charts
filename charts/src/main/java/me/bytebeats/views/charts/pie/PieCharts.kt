package me.bytebeats.views.charts.pie

import me.bytebeats.views.charts.util.FLOAT_360

/**
 * Created by bytebeats on 2021/9/24 : 14:27
 * E-mail: happychinapc@gmail.com
 * Quote: Peasant. Educated. Worker
 */

internal fun calculateAngle(
    sliceLength: Float,
    totalLength: Float,
    progress: Float
): Float = FLOAT_360 * sliceLength * progress / totalLength
