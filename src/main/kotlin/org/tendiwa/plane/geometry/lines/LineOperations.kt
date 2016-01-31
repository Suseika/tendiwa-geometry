package org.tendiwa.plane.geometry.lines

import org.tendiwa.math.constants.EPSILON
import org.tendiwa.math.doubles.isCloseToZero
import org.tendiwa.math.doubles.sqrt
import org.tendiwa.math.doubles.square
import org.tendiwa.math.matrices.determinant
import org.tendiwa.plane.geometry.points.Point

/**
 * Computes an intersection of this line with another line.
 * @return The intersection point, or null if the lines are parallel.
 */
infix fun Line.intersectionWith(other: Line): Point? {
    val zn = determinant(this.a, this.b, other.a, other.b)
    if (zn.isCloseToZero) {
        return null
    }
    return Point(
        (other.b * this.c - this.b * other.c) / zn,
        (this.a * other.c - other.a * this.c) / zn
    )
}

fun Line.contains(point: Point): Boolean =
    this distanceTo point < EPSILON

infix fun Point.distanceTo(line: Line): Double =
    Math.abs(line.a * this.x + line.b * this.y + line.c)
        .div((line.a.square + line.b.square).sqrt)

infix fun Line.distanceTo(point: Point): Double =
    point distanceTo this

