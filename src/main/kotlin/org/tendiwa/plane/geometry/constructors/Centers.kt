package org.tendiwa.plane.geometry.constructors

import org.tendiwa.plane.geometry.dimensions.Dimension
import org.tendiwa.plane.geometry.points.Point
import org.tendiwa.plane.geometry.rectangles.Rectangle

fun centeredRectangle(center: Point, size: Dimension): Rectangle =
    Rectangle(
        center.x - size.width / 2,
        center.y - size.height / 2,
        size.width,
        size.height
    )

