package org.tendiwa.geometry.trails

import org.tendiwa.geometry.points.Point
import org.tendiwa.plane.directions.Direction
import java.util.*

class Trail(val start: Point) {
    private val points: MutableList<Point> =
        ArrayList<Point>().apply { add(start) }

    private var last: Point = start

    fun move(dx: Double, dy: Double) {
        last = Point(last.x + dx, last.y + dy)
        points.add(last)
    }

    fun moveX(dx: Double) {
        last = Point(last.x+dx, last.y)
        points.add(last)
    }

    fun moveY(dy: Double) {
        last = Point(last.x, last.y+dy)
    }

    fun move(distance: Double, direction: Direction) {
        last = Point(last.x+direction.dx, last.y+ direction.dy)
    }
}
