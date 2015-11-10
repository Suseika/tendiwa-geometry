package org.tendiwa.geometry.grid.dimensions

infix fun Int.by(multiplier: Int) : GridDimension =
    GridDimension(this, multiplier)
