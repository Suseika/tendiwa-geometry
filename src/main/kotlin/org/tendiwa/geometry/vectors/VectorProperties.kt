package org.tendiwa.geometry.vectors

import org.tendiwa.geometry.points.Point
import org.tendiwa.math.doubles.sqrt
import org.tendiwa.math.doubles.square

val Vector.magnitude: Double
    get() = (x.square + y.square).sqrt

val Vector.isZero: Boolean
    get()  = x == 0.0 && y == 0.0

val Vector.point: Point
    get() = Point(x, y)

