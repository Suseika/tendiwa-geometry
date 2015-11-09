package org.tendiwa.geometry.continuum.constructors

import org.tendiwa.geometry.continuum.Dimension
import org.tendiwa.geometry.continuum.circles.Circle
import org.tendiwa.geometry.continuum.rectangles.Rectangle

val Circle.rectangularHull: Rectangle
    get() = centeredRectangle(center, Dimension(radius * 2, radius * 2))

