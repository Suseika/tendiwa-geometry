package org.tendiwa.plane.geometry.segments.cut

import org.tendiwa.plane.geometry.points.Point
import org.tendiwa.plane.geometry.points.distanceTo
import org.tendiwa.plane.geometry.segments.Segment
import java.util.*

/**
 * Represents a Segment split into multiple consecutive pieces. Where one
 * segment ends, another starts. The first segment doesn't share its start with
 * any segment, and the last segment doesn't share its end with any segment.
 * @param originalSegment The segment to split.
 * @param expectedNumberOfShreds Expected size of an internal [ArrayList]
 */
class MutableShreddedSegment(
    override val originalSegment: Segment
) : CutSegment {
    private val segments = TreeSet<Segment>({
        a, b ->
        java.lang.Double.compare(
            a.start.distanceTo(originalSegment.start),
            b.start.distanceTo(originalSegment.start)
        )
    })
        .apply { add(originalSegment) }
    override val parts : List<Segment>
        get() = segments.toList()

    internal constructor(
        originalSegment: Segment,
        splitPoints: List<Point>
    ) : this(originalSegment) {
        splitPoints.forEach { splitAt(it) }
    }

    fun splitAt(point: Point) {
        if (canSplitAtPoint(point)) {
            throw IllegalArgumentException(
                "Can't split segment $originalSegment at point $point because" +
                    " it is either an endpoint of the segment, or an existing" +
                    " split point"
            )
        }
        val segmentToSplit = partWithPoint(point);
        val onePart = Segment(segmentToSplit.start, point);
        val anotherPart = Segment(point, segmentToSplit.end);
        split(segmentToSplit, onePart, anotherPart);
    }

    private fun canSplitAtPoint(point: Point) =
        originalSegment.start == point
            || originalSegment.end == point
            || cuts.any { it == point }

    override fun partWithPoint(point: Point): Segment =
        segments
            .find { s -> isPointInBoundingRectangle(point, s) }
            ?:
            throw IllegalArgumentException(
                "$point is not on the original segment $originalSegment"
            )

    private fun split(
        segment: Segment,
        onePart: Segment,
        anotherPart: Segment
    ) {
        assert(segments.contains(segment))
        segments.remove(segment);
        segments.add(onePart);
        segments.add(anotherPart);
    }
}

private fun isPointInBoundingRectangle(
    point: Point,
    segment: Segment
): Boolean =
    if (segment.start.x != segment.end.x) {
        val minX = Math.min(segment.start.x, segment.end.x);
        val maxX = Math.max(segment.start.x, segment.end.x);
        point.x > minX && point.x < maxX;
    } else {
        val minY = Math.min(segment.start.y, segment.end.y);
        val maxY = Math.max(segment.start.y, segment.end.y);
        point.y > minY && point.y < maxY;
    }
