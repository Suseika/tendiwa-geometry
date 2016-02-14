package org.tendiwa.plane.geometry.polygons

import org.tendiwa.plane.geometry.points.Point

data class ClockwisePolygon
internal constructor(
    override val points: List<Point>
) : Polygon {
    override val steps: List<Point>
        get() = points + points[0]

    override fun isClockwise(): Boolean = true
}
