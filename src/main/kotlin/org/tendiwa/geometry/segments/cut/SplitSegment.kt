package org.tendiwa.geometry.segments.cut

import org.tendiwa.geometry.points.Point
import org.tendiwa.geometry.segments.Segment

/**
 * [Segment] split into two segments.
 */
class SplitSegment(
    override val originalSegment: Segment,
    splitPoint: Point
) : CutSegment {
    val firstHalf = Segment(originalSegment.start, splitPoint)
    val secondHalf = Segment(splitPoint, originalSegment.end)
    val middlePoint: Point
        get() = firstHalf.end

    override fun partWithPoint(point: Point) {
        throw UnsupportedOperationException()
    }

    override val parts: List<Segment>
        get() = listOf(firstHalf, secondHalf)
    override val cuts: List<Point>
        get() = listOf(middlePoint)
    override val hasBeenCut: Boolean
        get() = true
}
