package org.tendiwa.plane.geometry.vectors

import org.tendiwa.math.doubles.sqrt
import org.tendiwa.math.doubles.square
import org.tendiwa.plane.geometry.points.Point

val Vector.magnitude: Double
    get() = (x.square + y.square).sqrt

val Vector.isZero: Boolean
    get() = x == 0.0 && y == 0.0

val Vector.point: Point
    get() = Point(x, y)

/**
 * Returns vector of the same magnitue pointing in the opposite direction.
 */
val Vector.reversed: Vector
    get() = Vector(-x, -y)
/**
 * Creates a vector with the same direction of magnitude 1.
 */
val Vector.normalized: Vector
    get() = this div magnitude

val Vector.rotatedQuarterClockwise: Vector
    get() = Vector(-y, x)
