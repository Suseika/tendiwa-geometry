package org.tendiwa.geometry.continuum.constructors

import org.tendiwa.geometry.continuum.Dimension
import org.tendiwa.geometry.continuum.points.Point
import org.tendiwa.geometry.continuum.rectangles.Rectangle

fun centeredRectangle(center: Point, size: Dimension): Rectangle =
    Rectangle(
        center.x - size.width / 2,
        center.y - size.height / 2,
        size.width,
        size.height
    )

