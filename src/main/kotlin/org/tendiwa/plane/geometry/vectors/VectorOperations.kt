package org.tendiwa.plane.geometry.vectors

import org.tendiwa.math.doubles.isCloseToZero
import org.tendiwa.plane.directions.OrdinalDirection

/**
 * Dot product of two vectors.
 */
infix fun Vector.dot(another: Vector): Double =
    x * another.x + y * another.y

infix fun Vector.dotPerp(another: Vector): Double =
    this.x * another.y - this.y * another.x

/**
 * Cross product of two vectors.
 */
infix fun Vector.cross(another: Vector): Double =
    this.x * another.y - this.y * another.x


infix operator fun Vector.div(scalar: Double): Vector =
    Vector(x / scalar, y / scalar)

infix operator fun Vector.div(scalar: Int): Vector =
    Vector(x / scalar.toDouble(), y / scalar.toDouble())


infix operator fun Vector.plus(another: Vector): Vector =
    Vector(x + another.x, y + another.y)

infix operator fun Vector.minus(another: Vector): Vector =
    Vector(x - another.x, y - another.y)

infix operator fun Vector.times(scalar: Double): Vector =
    Vector(x * scalar, y * scalar)

infix operator fun Vector.times(scalar: Int): Vector =
    Vector(x * scalar, y * scalar)

operator fun Vector.unaryMinus(): Vector =
    Vector(-x, -y)

/**
 * Rotates a vector by particular angle.
 * @param radians Angle in radians.
 */
fun Vector.rotate(radians: Double): Vector {
    val ca = Math.cos(radians)
    val sa = Math.sin(radians)
    return Vector(ca * x - sa * y, sa * x + ca * y)
}

infix fun Vector.isCollinear(other: Vector): Boolean {
    if (this.isZero || other.isZero) {
        return false
    }
    val a = this.normalized
    val b = other.normalized
    val sub = a - b
    if (sub.x.isCloseToZero && sub.y.isCloseToZero) {
        return true
    }
    val subNeg = a + b
    if (subNeg.x.isCloseToZero && subNeg.y.isCloseToZero) {
        return true
    }
    return false
}

fun Vector.angleBetween(b: Vector, clockwise: Boolean): Double {
    if (this == b) {
        throw IllegalArgumentException(
            "Can't compute angle between equal vectors $this and $b"
        )
    }
    val angleA: Double = Math.atan2(this.y, this.x)
    val angleB: Double = Math.atan2(b.y, b.x)
    var angle = angleA - angleB
    if (clockwise) {
        angle = -angle
    }
    if (angle < 0) {
        angle += Math.PI * 2
    }
    return angle
}

/**
 * Checks if clockwise angle between this vector and another vector is
 * `>Math.PI`. Relative to angle's bisector, this vector is considered * counter-clockwise, and another is considered clockwise. *
 * @param cw Another vector.
 * @return true if the angle between vectors going clockwise from this vector to
 * [cw] is reflex, false otherwise.
 */
infix fun Vector.makesReflexAngle(cw: Vector): Boolean =
    cw dotPerp this > 0

/**
 * Same as `rotated90ccw dot vector` where `rotated90ccw` is this vector
 * rotated 90 degrees counter-clockwise.
 *
 * [Perp dot product on WolframMathWorld](http://mathworld.wolfram.com/PerpDotProduct.html)
 */
infix fun Vector.perpDotProduct(vector: Vector): Double =
    this.x * vector.y - this.y * vector.x

fun Vector.isInQuarter(quarter: OrdinalDirection): Boolean =
    when (quarter) {
        OrdinalDirection.NW -> x < 0 && y < 0
        OrdinalDirection.NE -> x > 0 && y < 0
        OrdinalDirection.SE -> x > 0 && y > 0
        OrdinalDirection.SW -> x < 0 && y > 0
    }
