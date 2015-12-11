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

/**
 * Returns a point on this segment.
 *
 * - For [position] of 0.0, returns [Segment.start];
 * - For [position] of 1.0, return [Segment.end];
 * - For all [position]s in `0.0..1.0`, returns a point on this segment linearly
 * shifted from [Segment.start] towards [Segment.end]
 * - For [position] outside `0.0..1.0` returns a point outside this segment
 * that is on the same line.
 */
fun Segment.slider(position: Double): Point =
    Point(
        start.x + dx * position,
        start.y + dy * position
    )

/**
 * Checks if a point is either [Segment.start] or [Segment.end]
 */
fun Segment.isEndpoint(point: Point): Boolean =
    start == point || end == point
