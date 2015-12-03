package org.tendiwa.geometry.polygons

import org.tendiwa.geometry.segments.Segment

val Polygon.lastSegment: Segment
    get() = Segment(points.first(), points.last())
