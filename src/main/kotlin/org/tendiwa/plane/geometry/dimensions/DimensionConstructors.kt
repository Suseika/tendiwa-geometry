package org.tendiwa.plane.geometry.dimensions

infix fun Double.by(other: Double): Dimension =
    Dimension(this, other)

