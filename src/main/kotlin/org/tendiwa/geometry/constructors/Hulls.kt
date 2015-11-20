package org.tendiwa.geometry.constructors

import org.tendiwa.geometry.circles.Circle
import org.tendiwa.geometry.dimensions.Dimension
import org.tendiwa.geometry.rectangles.Rectangle

val Circle.rectangularHull: Rectangle
    get() = centeredRectangle(center, Dimension(radius * 2, radius * 2))

