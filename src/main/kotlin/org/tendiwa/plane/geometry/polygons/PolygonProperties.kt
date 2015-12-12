package org.tendiwa.plane.geometry.polygons

import org.tendiwa.plane.geometry.segments.Segment
import org.tendiwa.plane.geometry.segments.length

val Polygon.lastSegment: Segment
    get() = Segment(points.first(), points.last())

val Polygon.perimeter: Double
    get() = segments.map { it.length }.sum()
