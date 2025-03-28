package com.nilutopia.mylibrary

import kotlin.math.sqrt
import kotlin.math.pow

data class Point(val x: Double, val y: Double)

fun Point.calculateDistanceTo(other: Point): Double {
    return sqrt((x - other.x).pow(2.0) + (y - other.y).pow(2.0))
}