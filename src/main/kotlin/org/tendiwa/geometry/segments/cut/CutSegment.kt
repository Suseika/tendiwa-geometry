package org.tendiwa.geometry.segments.cut

import org.tendiwa.geometry.points.Point
import org.tendiwa.geometry.segments.Segment

/**
 * [Segment] split into parts with cuts along this segment.
 */
interface CutSegment {
	val originalSegment: Segment

	val parts: List<Segment>

	val cuts: List<Point>

	val hasBeenCut: Boolean

	fun partWithPoint(startingPoint: Point);
}
