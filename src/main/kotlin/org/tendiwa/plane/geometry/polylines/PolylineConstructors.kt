package org.tendiwa.plane.geometry.polylines

import org.tendiwa.plane.geometry.points.Point

fun Polyline(points: List<Point>): Polyline =
    DefaultPolyline(points)

fun Polyline(vararg points: Point): Polyline =
    Polyline(points.toList())

private data class DefaultPolyline(override val points: List<Point>) : Polyline {
    override val steps: List<Point>
        get() = points
}
