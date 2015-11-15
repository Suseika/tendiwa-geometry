package org.tendiwa.geometry.points

/**
 * Creates a new point relative to the original point.
 * @param dx Shift by x axis.
 * @param dy Shift by y axis.
 * @return New Point moved from this point.
 */
fun Point.move(dx: Double, dy: Double): Point =
    Point(x + dx, y + dy)

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
