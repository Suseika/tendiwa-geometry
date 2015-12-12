package org.tendiwa.plane.geometry.circles

import org.tendiwa.plane.geometry.points.Point
import org.tendiwa.plane.geometry.points.distanceTo

fun Circle.contains(point: Point): Boolean =
    center distanceTo point < radius
