package org.tendiwa.plane.geometry.points

import org.tendiwa.plane.geometry.vectors.Vector

val Point.radiusVector: Vector
    get() = Vector(x, y)

