package org.tendiwa.geometry.continuum.segments

import org.tendiwa.math.doubles.sqrt
import org.tendiwa.math.doubles.square

val Segment.length: Double
    get() = ((end.x - start.x).square + (end.y - start.y).square).sqrt

val Segment.dx: Double
    get() = end.x - start.x

val Segment.dy: Double
    get() = end.y - start.y
