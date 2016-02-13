package org.tendiwa.plane.geometry.polygons.cut

import org.tendiwa.math.sliders.CircularSlider
import org.tendiwa.plane.geometry.points.Point
import org.tendiwa.plane.geometry.polygons.Polygon
import org.tendiwa.plane.geometry.polygons.sliders.SliderPolygon
import org.tendiwa.plane.geometry.polygons.sliders.edges
import org.tendiwa.plane.geometry.segments.Segment
import org.tendiwa.tools.argumentConstraint
import java.util.*

fun Polygon.cut(vararg cutPositions: Double): CutPolygon =
    cut(cutPositions.map { CircularSlider(it) })

fun Polygon.cut(sliders: List<CircularSlider>): CutPolygon =
    CutPolygon(this, sliders)

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
            .map { Pair(it.segment, it.multisegmentCutIndices) }
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

/**
 * Maps edges of the original polygon to [CutPolygonEdge]s.
 * @param cutPositions Positions of cuts. Must be sorted.
 * @return Cut edges, in polygonwise order.
 */
private fun SliderPolygon.cutEdges(
    cutPositions: List<CircularSlider>
): List<CutPolygonEdge> {
    argumentConstraint(
        cutPositions,
        { it.sortedBy { slider -> slider.position } == cutPositions },
        { "cutPositions must be sorted in ascending order" }
    )
    argumentConstraint(
        cutPositions,
        { it.distinct() == it },
        { "cutPositions must contain only distinct sliders"}
    )
    return edges
        .fold(
            ArrayList<CutPolygonEdge>(
                cutPositions.size
            ), // mutable accumulator
            { lists, sliderEdge ->
                lists.apply {
                    add(
                        CutPolygonEdge(
                            cutPositions = cutPositions,
                            previous = lists.lastOrNull(),
                            sliderEdge = sliderEdge
                        )
                    )
                }
            }
        )
}
