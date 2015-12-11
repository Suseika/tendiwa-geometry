package org.tendiwa.geometry.segments

import org.tendiwa.geometry.vectors.Vector
import org.tendiwa.math.doubles.sqrt
import org.tendiwa.math.doubles.square

val Segment.length: Double
    get() = ((end.x - start.x).square + (end.y - start.y).square).sqrt

val Segment.dx: Double
    get() = end.x - start.x

val Segment.dy: Double
    get() = end.y - start.y

/**
 * Returns vector from [Segment.start] to [Segment.end].
 */
val Segment.vector: Vector
    get() = Vector(end.x - start.x, end.y - start.y)

val Segment.reverse: Segment
    get() = Segment(end, start)

val Segment.slope: Double
    get() = dy / dx
