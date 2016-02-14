package org.tendiwa.plane.geometry.polygons

import org.tendiwa.plane.geometry.points.Point

data class OrientedPolygon internal constructor(
    override val points: List<Point>
): Polygon {
    override val steps: List<Point>
        get() = points + points[0]

    private val clockwise: Boolean = isClockwise()

    override fun isClockwise(): Boolean =
        clockwise
}

fun Polygon.toOriented(): OrientedPolygon =
    OrientedPolygon(points)
