package org.tendiwa.plane.geometry.lines

/**
 * Line in ℝ×ℝ, represented with the standard form line equation ax + by = c
 */
data class Line(
    val a: Double,
    val b: Double,
    val c: Double
)

fun HorizontalLine(y: Double): Line =
    Line(a = 0.0, b = 1.0, c = y)

