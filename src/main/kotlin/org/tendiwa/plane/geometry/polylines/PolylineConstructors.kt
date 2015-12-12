package org.tendiwa.plane.geometry.polylines

import org.tendiwa.plane.geometry.points.Point

fun Polyline(points: List<Point>): Polyline =
    DefaultPolyline(points)

private data class DefaultPolyline(override val points: List<Point>) : Polyline
