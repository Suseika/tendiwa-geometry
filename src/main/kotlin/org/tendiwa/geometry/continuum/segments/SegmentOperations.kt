package org.tendiwa.geometry.continuum.segments

import org.tendiwa.geometry.continuum.points.move

fun Segment.parallel(distance: Double, fromLeft: Boolean): Segment {
    val distanceSigned = if (fromLeft) -distance else distance
    return this.move(
        -this.dx / this.length * distanceSigned,
        this.dy / this.length * distanceSigned
    )
}

fun Segment.move(dx: Double, dy: Double): Segment
    = Segment(start.move(dx, dy), end.move(dx, dy))
