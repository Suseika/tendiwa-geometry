package org.tendiwa.geometry.constructors

import org.tendiwa.geometry.points.Point
import org.tendiwa.geometry.points.move
import org.tendiwa.geometry.segments.Segment

/**
 * Creates a [Segment] by placing its another end *relative* to this point.
 */
fun Point.spanSegment(dx: Double, dy: Double): Segment =
    Segment(this, this.move(dx, dy))

fun Point.spanHorizontalSegment(dx: Double): Segment =
    Segment(this, this.move(dx, 0.0))

fun Point.spanVerticalSegment(dy: Double): Segment =
    Segment(this, this.move(0.0, dy))

