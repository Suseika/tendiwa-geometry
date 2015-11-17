package org.tendiwa.geometry.vectors

import org.tendiwa.geometry.EPSILON

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
