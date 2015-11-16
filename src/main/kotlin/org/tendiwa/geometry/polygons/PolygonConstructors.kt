package org.tendiwa.geometry.polygons

import org.tendiwa.geometry.points.Point

fun Polygon(a: Point, b: Point, c: Point, vararg rest: Point): Polygon =
    DefaultPolygon(listOf(a, b, c, *rest))

fun Polygon(points: List<Point>): Polygon =
    DefaultPolygon(points.apply { validatePointList(this) })

private fun validatePointList(points: List<Point>) {
    if (points.size < 3) {
        throw IllegalArgumentException(
            "There must be at least 3 points to construct a polygon; you " +
                "provided ${points.size}: $points"
        )
    }
}

private data class DefaultPolygon(override val points: List<Point>) : Polygon

