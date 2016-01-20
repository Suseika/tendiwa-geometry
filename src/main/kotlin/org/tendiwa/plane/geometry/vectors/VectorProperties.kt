package org.tendiwa.plane.geometry.vectors

import org.tendiwa.math.doubles.sqrt
import org.tendiwa.math.doubles.square
import org.tendiwa.plane.directions.Direction
import org.tendiwa.plane.directions.RadianDirection
import org.tendiwa.plane.geometry.points.Point
import java.lang.Math.atan2

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

val Vector.rotatedQuarterCCW: Vector
    get() = Vector(-y, x)

val Vector.direction: Direction
    get() {
        val atan = atan2(y, x)
        return RadianDirection(
            when {
                atan < 0 -> Math.PI * 2 + atan
                else -> atan
            }
        )
    }
