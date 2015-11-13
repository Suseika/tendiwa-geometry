package org.tendiwa.geometry.continuum.polygons

import org.tendiwa.geometry.continuum.points.Point
import org.tendiwa.geometry.continuum.shapes.Shape

/**
 * A polygon.
 */
data class Polygon(
    val points: List<Point>
) : Shape {
    override fun iterator(): Iterator<Point> =
        points.iterator()
}
