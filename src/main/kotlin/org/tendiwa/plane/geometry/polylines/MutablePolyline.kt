package org.tendiwa.plane.geometry.polylines

import org.tendiwa.plane.geometry.points.Point
import java.util.*

open class MutablePolyline() : Polyline {
    private val mutablePoints: MutableList<Point> = ArrayList(10);

    override val points: List<Point> = mutablePoints

    fun addInFront(point: Point) {
        mutablePoints.add(point)
    }
}
