package org.tendiwa.geometry.points

import org.tendiwa.geometry.vectors.Vector
import org.tendiwa.plane.directions.Direction

/**
 * Creates a new point relative to the original point.
 * @param dx Shift by x axis.
 * @param dy Shift by y axis.
 * @return New Point moved from this point.
 */
fun Point.move(dx: Double, dy: Double): Point =
    Point(x + dx, y + dy)

fun Point.move(vector: Vector): Point =
    Point(x + vector.x, y + vector.y)

fun Point.move(direction: Direction, distance: Double): Point =
    Point(
        x + direction.dx * distance,
        y + direction.dy * distance
    )

fun Point.moveHorizontally(dx: Double): Point =
    Point(x + dx, y)

fun Point.moveVertically(dy: Double): Point =
    Point(x, y + dy)

/**
 * Distance to another point.
 * @param another Another point.
 * @return New Point
 */
infix fun Point.distanceTo(another: Point): Double {
    val dx = another.x - this.x
    val dy = another.y - this.y
    return Math.sqrt(dx * dx + dy * dy)
}

/**
 * Returns the position of this point if `other` was the beginning of
 * coordinates.
 */
infix fun Point.relativeTo(other: Point): Point =
    Point(this.x - other.x, this.y - other.y)
