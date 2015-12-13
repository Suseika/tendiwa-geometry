package org.tendiwa.plane.geometry.polygons

fun Polygon.isClockwise(): Boolean =
    // TODO: Can be optimized if segment objects are not created, and only
    // existing points are used.
    segments
        .map { (it.end.x - it.start.x) / (it.end.y + it.start.y) }
        .sum()
        .apply { assert(this != 0.0) }
        .run { this > 0.0 }

