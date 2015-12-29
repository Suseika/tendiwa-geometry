package org.tendiwa.plane.geometry.polygons.cut

import org.tendiwa.plane.geometry.points.Point
import org.tendiwa.plane.geometry.sliders.CircularSlider
import org.tendiwa.plane.geometry.sliders.SliderPolygonEdge
import org.tendiwa.plane.geometry.sliders.alternativePosition

/**
 * Edge of a [CutPolygon].
 *
 * It is similar to [Multisegment] in that it contains points between two
 * adjacent polygon's edge corners. But unlike [Multisegment], [CutPolygonEdge]
 * may contain a point that is right at the start of the segment.
 *
 * The purpose of this class is to find out which cuts lie on a particular
 * segment of the polygon, and whether one of those cuts lies on the start of
 * that segment, i.e. in a corner of the polygon. If a cut lies on a corner
 * of a polygon, then it belongs to [CutPolygonEdge] that starts on that
 * corner, but not to [CutPolygonEdge] that end on tha corner.
 */
class CutPolygonEdge
/**
 * @param cutPositions Positions of each corner of a polygon, ordered
 * polygonwise.
 * @param previous Edge that lies counter-polygonwise from this edge. It is
 * `null` if this is an edge corresponding to the 0th segment of the polygon.
 * @param sliderEdge The edge in slider form.
 */
constructor(
    cutPositions: List<CircularSlider>,
    previous: CutPolygonEdge?,
    sliderEdge: SliderPolygonEdge
) {
    val segment = sliderEdge.segment

    val startingCutIndex: Int = previous?.nextStartingCutIndex ?: 0

    private val pointsOnSegment: List<Point> =
        cutPositions
            .subList(startingCutIndex, cutPositions.size)
            .takeWhile {
                it.position < sliderEdge.end.alternativePosition
            }
            .map { sliderEdge.point2D(it) }

    /**
     * [startingCutIndex] for the next [CutPolygonEdge].
     */
    private val nextStartingCutIndex: Int =
        startingCutIndex + pointsOnSegment.size

    private val firstPointIsCorner: Boolean =
        !pointsOnSegment.isEmpty()
            && pointsOnSegment.first() == sliderEdge.segment.start

    /**
     * Cut at a corner of the polygon. That corner corresponds to the start of
     * [segment].
     */
    val atCorner: Point? =
        when (firstPointIsCorner) {
            true -> pointsOnSegment.first()
            false -> null
        }

    /**
     * Cuts along the length of the segment other than [atCorner].
     */
    val betweenCorners: List<Point> =
        when (firstPointIsCorner) {
            true -> pointsOnSegment.drop(1)
            false -> pointsOnSegment
        }

    val multisegmentCutIndices: List<Int>
        get() = IntRange(
            if (atCorner == null) 0 else 1,
            pointsOnSegment.lastIndex
        )
            .map { startingCutIndex + it }
}
