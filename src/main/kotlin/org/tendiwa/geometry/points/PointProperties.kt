package org.tendiwa.geometry.points

import org.tendiwa.geometry.vectors.Vector

val Point.radiusVector: Vector
    get() = Vector(x, y)

