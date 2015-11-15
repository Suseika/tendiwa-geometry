package org.tendiwa.geometry.polygons

import org.tendiwa.geometry.points.Point

fun Polygon(vararg points: Point): Polygon =
    Polygon(points.asList())

