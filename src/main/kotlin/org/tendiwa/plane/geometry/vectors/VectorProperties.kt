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
// TODO: Inconsistency: Vector.reversed, but Segment.reverse
val Vector.reversed: Vector
    get() = Vector(-x, -y)
/**
 * Creates a vector with the same direction of magnitude 1.
 */
val Vector.normalized: Vector
    get() = this div magnitude

val Vector.rotatedQuarterClockwise: Vector
    get() = Vector(-y, x)

val Vector.direction: Double
    get() =
    Math.atan2(y, x)
        .run {
            if (this < 0) {
                Math.PI * 2 + this;
            } else {
                this
            }
        }
