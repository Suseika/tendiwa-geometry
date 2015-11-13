package org.tendiwa.geometry.continuum.polylines

import org.tendiwa.geometry.continuum.points.Point
import org.tendiwa.geometry.continuum.shapes.Shape

data class Polyline(
    val points: List<Point>
) : Shape {
    override fun iterator(): Iterator<Point> =
        points.iterator()
}
