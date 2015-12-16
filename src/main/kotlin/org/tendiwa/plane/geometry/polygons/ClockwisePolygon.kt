package org.tendiwa.plane.geometry.polygons

import org.tendiwa.plane.geometry.points.Point

data class ClockwisePolygon
internal constructor(
    override val points: List<Point>
) : Polygon {
    override fun isClockwise(): Boolean = true
}
