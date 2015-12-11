package org.tendiwa.geometry.segments

import org.tendiwa.geometry.points.Point
import org.tendiwa.geometry.points.move

fun Segment.parallel(distance: Double, fromLeft: Boolean): Segment {
    val distanceSigned = if (fromLeft) -distance else distance
    return this.move(
        -this.dy / this.length * distanceSigned,
        this.dx / this.length * distanceSigned
    )
}

fun Segment.move(dx: Double, dy: Double): Segment
    = Segment(start.move(dx, dy), end.move(dx, dy))

fun Segment.isParallel(segment: Segment): Boolean =
    this.dx * segment.dy - this.dy * segment.dx == 0.0

fun Segment.middle(): Point =
    Point((start.x + end.x) / 2, (start.y + end.y) / 2)
