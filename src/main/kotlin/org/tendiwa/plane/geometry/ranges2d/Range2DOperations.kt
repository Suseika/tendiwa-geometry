package org.tendiwa.plane.geometry.ranges2d

import org.tendiwa.plane.geometry.rectangles.Rectangle

infix fun Range2D.overlaps(other: Range2D) =
    minX < other.maxX && maxX > other.minX && minY < other.maxY && maxY > other.minY;

fun Range2D.grow(d: Double): Rectangle =
    Rectangle(minX - d, minY - d, width + d * 2, height + d * 2)

val Range2D.width: Double
    get() = maxX - minX

val Range2D.height: Double
    get() = maxY - minY
