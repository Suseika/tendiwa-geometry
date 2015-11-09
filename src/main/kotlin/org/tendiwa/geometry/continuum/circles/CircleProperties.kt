package org.tendiwa.geometry.continuum.circles

import org.tendiwa.math.doubles.square

val Circle.diameter: Double
    get() = radius * 2

val Circle.area: Double
    get() = Math.PI * radius.square

val Circle.circumference: Double
    get() = 2 * Math.PI * radius
