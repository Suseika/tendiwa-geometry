package org.tendiwa.geometry.continuum.lines

import org.tendiwa.geometry.continuum.EPSILON
import org.tendiwa.geometry.continuum.points.Point
import org.tendiwa.math.doubles.sqrt
import org.tendiwa.math.doubles.square
import org.tendiwa.math.matrices.determinant

/**
 * Computes an intersection of this line with another line.
 */
infix fun Line.intersectionWith(another: Line): Point? {
    val zn = determinant(this.a, this.b, another.a, another.b)
    if (Math.abs(zn) < EPSILON) {
        return null
    }
    return Point(
        -determinant(this.c, this.b, another.c, another.b),
        -determinant(this.a, this.c, another.a, another.c)
    )
}

fun Line.contains(point: Point): Boolean
    = this distanceTo point < EPSILON

infix fun Point.distanceTo(line: Line): Double =
    Math.abs(line.a * this.x + line.b * this.y + line.c)
        .div((line.a.square + line.b.square).sqrt)

infix fun Line.distanceTo(point: Point): Double =
    point distanceTo this

