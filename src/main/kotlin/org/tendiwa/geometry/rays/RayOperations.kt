package org.tendiwa.geometry.rays

import org.tendiwa.geometry.points.Point
import org.tendiwa.geometry.points.move

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
