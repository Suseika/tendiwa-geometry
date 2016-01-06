package org.tendiwa.plane.geometry.rays

import org.tendiwa.plane.geometry.points.Point
import org.tendiwa.plane.geometry.points.move
import org.tendiwa.plane.geometry.segments.Segment

fun Ray.pointOnRay(radius: Double): Point =
    start.move(
        Math.cos(direction) * radius,
        Math.sin(direction) * radius
    )

fun Ray.changeDirection(direction: Double): Ray =
    Ray(start, direction)

fun Ray.changeStart(start: Point): Ray =
    Ray(start, direction)

fun Ray.inverse(): Ray =
    Ray(start, Math.PI * 2 - direction)

fun Ray.rotate(angle: Double): Ray =
    changeDirection(direction + angle)

/**
 * Returns rays at regular intervals starting from this ray, clockwise.
 */
fun Ray.sun(raysNum: Int): List<Ray> {
    val rayAngle: Double = (Math.PI * 2 / raysNum)
    return (0 until raysNum)
            .map { i -> this.rotate(i * rayAngle) }
}

/**
 * Returns a segment from the beginning of the ray to a point on ray that is
 * [length] units away from the beginning.
 */
fun Ray.segment(length: Double): Segment =
    Segment(start, pointOnRay(length))
