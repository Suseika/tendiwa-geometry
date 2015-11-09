package org.tendiwa.geometry.grid

infix fun Int.by(multiplier: Int) : GridDimension =
    GridDimension(this, multiplier)
