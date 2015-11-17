package org.tendiwa.geometry.vectors

import org.tendiwa.math.constants.EPSILON


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

infix operator fun Vector.plus(another: Vector): Vector =
    Vector(x + another.x, y + another.y)

infix operator fun Vector.minus(another: Vector): Vector =
    Vector(x - another.x, y - another.y)

infix operator fun Vector.times(scalar: Double): Vector =
    Vector(x * scalar, y * scalar)

/**
 * Rotates a vector by particular angle.
 * @param radians Angle in radians.
 */
fun Vector.rotate(radians: Double): Vector {
    val ca = Math.cos(radians)
    val sa = Math.sin(radians)
    return Vector(ca * x - sa * y, sa * x + ca * y)
}

fun Vector.rotateQuarterClockwise(): Vector =
    Vector(-y, x)

/**
 * Returns vector of the same magnitue pointing in the opposite direction.
 */
fun Vector.reverse(): Vector =
    Vector(-x, -y)

/**
 * Creates a vector with the same direction of magnitude 1.
 */
fun Vector.normalize(): Vector =
    this div magnitude

infix fun Vector.isCollinear(other: Vector): Boolean {
    if (this.isZero || other.isZero) {
        return false
    }
    val a = this.normalize()
    val b = other.normalize()
    val sub = a - b
    if (Math.abs(sub.x) < EPSILON && Math.abs(sub.y) < EPSILON) {
        return true
    }
    val subNeg = a + b
    if (Math.abs(subNeg.x) < EPSILON && Math.abs(subNeg.y) < EPSILON) {
        return true
    }
    return false
}

fun Vector.angleBetween(b: Vector, clockwise: Boolean): Double {
    val angleA: Double = Math.atan2(b.y, b.x);
    val angleB: Double = Math.atan2(this.y, this.x);
    var angle = angleA - angleB;
    if (clockwise) {
        angle = -angle;
    }
    if (angle < 0) {
        angle += Math.PI * 2;
    }
    return angle;
}
