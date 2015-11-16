package org.tendiwa.geometry.trails

import org.tendiwa.geometry.points.Point
import org.tendiwa.plane.directions.Direction
import java.util.*

class Trail(val start: Point) {
    private val mutablePoints: MutableList<Point> =
        ArrayList<Point>().apply { add(start) }

    val points: List<Point>
        get() = mutablePoints

    private var last: Point = start

    fun move(dx: Double, dy: Double) {
        last = Point(last.x + dx, last.y + dy)
        mutablePoints.add(last)
    }

    fun moveX(dx: Double) {
        last = Point(last.x + dx, last.y)
        mutablePoints.add(last)
    }

    fun moveY(dy: Double) {
        last = Point(last.x, last.y + dy)
        mutablePoints.add(last)
    }

    fun moveTo(point: Point) {
        last = point
        mutablePoints.add(last)
    }

    fun move(distance: Double, direction: Direction) {
        last = Point(
            last.x + direction.dx * distance,
            last.y + direction.dy * distance
        )
        mutablePoints.add(last)
    }
}
