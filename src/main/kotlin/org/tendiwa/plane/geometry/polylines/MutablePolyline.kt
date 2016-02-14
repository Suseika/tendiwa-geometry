package org.tendiwa.plane.geometry.polylines

import org.tendiwa.plane.geometry.points.Point
import java.util.*

open class MutablePolyline() : Polyline {
    private val mutablePoints: MutableList<Point> = ArrayList(10);

    override val points: List<Point> = mutablePoints

    override val steps: List<Point>
        get() = points

    fun addInFront(point: Point) {
        mutablePoints.add(point)
    }
}
