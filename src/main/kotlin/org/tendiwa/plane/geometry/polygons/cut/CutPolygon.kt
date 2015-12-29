package org.tendiwa.plane.geometry.polygons.cut

import org.tendiwa.plane.geometry.points.Point
import org.tendiwa.plane.geometry.polygons.Polygon
import org.tendiwa.plane.geometry.segments.Segment
import org.tendiwa.plane.geometry.sliders.CircularSlider
import org.tendiwa.plane.geometry.sliders.SliderPolygon

fun Polygon.cut(cutPositions: List<Double>): CutPolygon =
    CutPolygon(this, cutPositions.map { CircularSlider(it) })

fun Polygon.cut(vararg cutPositions: Double): CutPolygon =
    CutPolygon(this, cutPositions.map { CircularSlider(it) })

fun SliderPolygon.cut(cutPositions: List<Double>): CutPolygon =
    CutPolygon(this, cutPositions.map { CircularSlider(it) })

/**
 * Polygon with an additional layer of points on its perimeter apart from the
 * corner points.
 * @param original Base polygon.
 * @param cutPositions Positions of cuts that divide [original]'s edges into
 * [Multisegment]s.
 */
class CutPolygon internal constructor(
    sliderPolygon: SliderPolygon,
    cutPositions: List<CircularSlider>
) {
    val original = sliderPolygon.original

    internal constructor(
        original: Polygon,
        cutPositions: List<CircularSlider>
    ): this(SliderPolygon(original), cutPositions)

    private val cutEdges: List<CutPolygonEdge> =
        sliderPolygon.cutEdges(cutPositions)

    private val edgeToCutsIndices: Map<Segment, List<Int>> =
        cutEdges
            .map { Pair(it.segment, it.cutIndices) }
            .toMap()

    private val cornerToCutIndex: Map<Point, Int> =
        cutEdges
            .filter { it.atCorner != null }
            .map { Pair(it.atCorner!!, it.startingCutIndex) }
            .toMap()
    /**
     * All points where the polygon has been cut, both at corners and on edges,
     * ordered polygonwise.
     */
    val cuts: List<Point> = cutEdges
        .flatMap { listOfNotNull(it.atCorner) + it.betweenCorners }

    /**
     * Returns all cuts that lie on a particular edge of the [original]. If a cut
     * lies right on the original polygon's point, then it is returned for a
     * segment whose start is on that point.
     */
    fun cutsOnSubsegment(edge: Segment): List<Point> =
        edgeToCutsIndices[edge]?.map { cuts[it] } ?: emptyList()
}
