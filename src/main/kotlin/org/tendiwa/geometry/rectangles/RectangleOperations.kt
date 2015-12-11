package org.tendiwa.geometry.rectangles

import org.tendiwa.geometry.points.Point

fun Rectangle.contains(point: Point): Boolean =
    point.x in x..maxX && point.y in y..maxY

