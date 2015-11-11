package org.tendiwa.geometry.grid.directions

val Direction.stepLength : Double
    get() = if (dx*dy == 0) 1.0 else 1.4142135623730951
