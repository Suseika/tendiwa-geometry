package org.tendiwa.geometry.circles

import org.tendiwa.geometry.points.Point
import org.tendiwa.geometry.points.distanceTo

fun Circle.contains(point: Point) : Boolean =
    center distanceTo point < radius
