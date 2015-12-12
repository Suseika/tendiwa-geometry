package org.tendiwa.plane.geometry.rectangles

import org.tendiwa.plane.geometry.points.Point

fun Rectangle.contains(point: Point): Boolean =
    point.x in x..maxX && point.y in y..maxY

