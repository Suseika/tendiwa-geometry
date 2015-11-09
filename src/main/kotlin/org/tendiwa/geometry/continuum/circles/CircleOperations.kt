package org.tendiwa.geometry.continuum.circles

import org.tendiwa.geometry.continuum.points.Point
import org.tendiwa.geometry.continuum.points.distanceTo

fun Circle.contains(point: Point) : Boolean =
    center distanceTo point < radius
