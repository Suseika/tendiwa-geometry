package org.tendiwa.geometry.constructors

import org.tendiwa.geometry.Dimension
import org.tendiwa.geometry.points.Point
import org.tendiwa.geometry.rectangles.Rectangle

fun centeredRectangle(center: Point, size: Dimension): Rectangle =
    Rectangle(
        center.x - size.width / 2,
        center.y - size.height / 2,
        size.width,
        size.height
    )

