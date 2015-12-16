package org.tendiwa.plane.geometry.polygons

fun Polygon.toClockwise(): ClockwisePolygon =
    when (isClockwise()) {
        true -> ClockwisePolygon(points)
        false -> ClockwisePolygon(points.reversed())
    }

