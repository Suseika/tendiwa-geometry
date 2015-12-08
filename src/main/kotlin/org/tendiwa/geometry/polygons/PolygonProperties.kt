package org.tendiwa.geometry.polygons

import org.tendiwa.geometry.segments.Segment
import org.tendiwa.geometry.segments.length

val Polygon.lastSegment: Segment
    get() = Segment(points.first(), points.last())

val Polygon.perimeter: Double
    get() = segments.map { it.length }.sum()
