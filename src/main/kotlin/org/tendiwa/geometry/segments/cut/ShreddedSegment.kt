package org.tendiwa.geometry.segments.cut

import org.tendiwa.geometry.points.Point
import org.tendiwa.geometry.segments.Segment

/**
 * [Segment] split into multiple consecutive segments.
 * @param originalSegment The segment to split.
 * @param splitPoints Points at which the [originalSegment] is split. May be
 * in any order. Must be strictly between `originalSegment.start` and
 * `originalSegment.end`. May contain 0 point, so [CutSegment.hasBeenCut]
 * will be false.
 */
class ShreddedSegment(
    originalSegment: Segment,
    splitPoints: List<Point>
) : CutSegment by MutableShreddedSegment(originalSegment, splitPoints)

