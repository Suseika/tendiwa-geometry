package org.tendiwa.geometry.continuum.polygons

import org.tendiwa.geometry.continuum.points.Point

fun Polygon(vararg points: Point): Polygon =
    Polygon(points.asList())

