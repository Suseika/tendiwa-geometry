package org.tendiwa.geometry.dimensions

infix fun Double.by(other: Double): Dimension =
    Dimension(this, other)

