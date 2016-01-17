package org.tendiwa.plane.geometry.segments

import org.tendiwa.math.doubles.square
import org.tendiwa.math.matrices.determinant
import org.tendiwa.plane.geometry.points.Point
import org.tendiwa.plane.geometry.points.move
import org.tendiwa.plane.geometry.segments.multi.DefaultMultisegment
import org.tendiwa.plane.geometry.segments.multi.Multisegment

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

fun Segment.hasCommonEndpoint(other: Segment): Boolean =
    other.isEndpoint(start) || other.isEndpoint(end)

fun Segment.commonEndpoint(other: Segment): Point =
    if (start == other.start || start == other.end) {
        start
    } else if (end == other.start || end == other.end) {
        end
    } else {
        throw IllegalArgumentException(
            "Segments $this and $other don't have a common endpoint"
        )
    }

/**
 * Returns [Segment.start] if [point] is [Segment.end], or returns
 * [Segment.end] if [point] is [Segment.start].
 * @throws IllegalArgumentException If [point] is neither [Segment.start] nor
 * [Segment.end].
 */
fun Segment.otherEnd(point: Point): Point =
    if (start == point) {
        end
    } else if (end == point) {
        start
    } else {
        throw IllegalArgumentException(
            "Argument must be one of the endpoints of $this; " +
                "argument was $point"
        )
    }

/**
 * Transform a segment into a [Multisegment].
 * @param cutPositions [slider] positions to place points on this segment at.
 * Each one must be within *(0.0;1.0)* range, and their order doesn't matter.
 */
fun Segment.cut(vararg cutPositions: Double): Multisegment =
    cutPositions
        .apply {
            if (cutPositions.any { it <= 0.0 || it >= 1.0 }) {
                throw IllegalArgumentException(
                    "All cut positions must be within (0.0..1.0); they are " +
                        "${cutPositions.toList()}"
                )
            }
        }
        .map { slider(it) }
        .let { cuts -> DefaultMultisegment(this@cut, cuts) }

/**
 * Check if a segment intersects another segment.
 *
 * Segments that lie on the same line or have equal endpoints are considered to
 * be non-intersecting.
 */
infix fun Segment.intersects(other: Segment): Boolean {
    // Algorithm is described in
    // https://stackoverflow.com/questions/3838329/how-can-i-check-if-two-segments-intersect/3842157#3842157
    if (this.slope == other.slope) {
        return false
    }
    val a = this.start
    val b = this.end
    val c = other.start
    val d = other.end
    val detA1 = determinant(
        a.x - c.x,
        b.x - c.x,
        a.y - c.y,
        b.y - c.y
    )
    val detA2 = determinant(
        a.x - d.x,
        b.x - d.x,
        a.y - d.y,
        b.y - d.y
    )
    if (Math.signum(detA1) != -Math.signum(detA2)) {
        return false
    }
    val detB1 = determinant(
        c.x - a.x,
        d.x - a.x,
        c.y - a.y,
        d.y - a.y
    )
    val detB2 = determinant(
        c.x - b.x,
        d.x - b.x,
        c.y - b.y,
        d.y - b.y
    )
    if (Math.signum(detB1) != -Math.signum(detB2)) {
        return false
    }
    return true
}

/**
 * Returns the projection of [point] onto this segment, or null if the
 * projection of [point] on line of this segment falls outside of the segment.
 */
fun Segment.project(point: Point) : Point? {
    val r = ((point.x - start.x) * (end.x - start.x) + (point.y - start.y) * (end.y - start.y)) / (dx.square + dy.square)
    if (r < 0.0 || r > 1.0) {
        return null
    }
    return Point(
        start.x + r * dx,
        start.y + r * dy
    )
}
