package org.tendiwa.plane.geometry.projections

import org.tendiwa.math.constants.EPSILON
import org.tendiwa.plane.geometry.points.Point
import org.tendiwa.plane.geometry.points.distanceTo
import org.tendiwa.plane.geometry.segments.Segment

/**
 * [Kelly 4.3.3.3]
 *
 * Relative position of a point on a 2d segment. It works in terms of a
 * 2-dimensional coordinate system with coordinates r and s where r-axis goes
 * along the segment and s-axis goes perpendicular to the segment.
 */
// TODO: This is very similar to Segment.slider
internal class PointPosition
/**
 * Computes distance from a point to a line.
 *
 * Algorithm is
 * [described by O'Rourke](http://www.faqs.org/faqs/graphics/algorithms-faq/) in
 * subject 1.02
 * @param segmentStart Start of a segment.
 * @param segmentEnd End of a segment.
 * @param point A point whose relative location of a segment is to be found.
 */
(segmentStart: Point, segmentEnd: Point, point: Point) {

    constructor(segment: Segment, point: Point) : this(
        segment.start,
        segment.end,
        point
    )

    /**
     * Position of a projection of point `point` to a line.
     *
     * `r == 0` means `point == segmentStart`, `r == 1` means
     * `point == segmentEnd`.
     */
    val r: Double
    /**
     * Position of a point `point` relative to a perpendicular of ab.
     *
     * `s > 0` means point is to the right from a segment (looking from
     * segment start to segment end),
     * `s < 0` means point is to the left from a segment.
     */
    private val s: Double

    /**
     * Perpendicular distance from `point` to segment's line.
     */
    val distanceToLine: Double

    init {
        val l = segmentStart.distanceTo(segmentEnd)
        r = ((point.x - segmentStart.x) * (segmentEnd.x - segmentStart.x) + (point.y - segmentStart.y) * (segmentEnd.y - segmentStart.y)) / (l * l)
        s = ((segmentStart.y - point.y) * (segmentEnd.x - segmentStart.x) - (segmentStart.x - point.x) * (segmentEnd.y - segmentStart.y)) / (l * l)
        distanceToLine = Math.abs(s) * l
    }

    fun pointOnSegment(segment: Segment): Point =
        Point(
            segment.start.x + r * (segment.end.x - segment.start.x),
            segment.start.y + r * (segment.end.y - segment.start.y)
        )

    fun fromSameSide(other: PointPosition): Boolean =
        Math.signum(this.s) == Math.signum(other.s)

    /**
     * Checks if the point is within the segment or r-axis.
     */
    fun isWithinSegmentRange(): Boolean = r in 0.0..1.0

    fun isStrictyWithinSegmentRange(): Boolean = r in EPSILON..(1.0 - EPSILON)
}
