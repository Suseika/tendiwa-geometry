package org.tendiwa.plane.geometry.polygons.sliders

import org.tendiwa.math.sliders.CircularSlider
import org.tendiwa.plane.geometry.polygons.Polygon
import org.tendiwa.plane.geometry.polygons.perimeter
import org.tendiwa.plane.geometry.segments.Segment
import org.tendiwa.plane.geometry.segments.length
import java.util.*

/**
 * A representation of a polygon where [Polygon.points] are represented as
 * [CircularSlider]s.
 */
class SliderPolygon(val original: Polygon) {

    /**
     * Points of this polygon in slider form, ordered polygonwise.
     */
    val sliders: List<CircularSlider> =
        original.segments
            .fold(
                Accumulator(original),
                { acc, edge -> acc.apply { addCornerAtBeginningOf(edge) } }
            )
            .sliders

    /**
     * Accumulator bearing mutable state required for constuction of this
     * [SliderPolygon].
     */
    private class Accumulator(polygon: Polygon) {
        val perimeter = polygon.perimeter

        var lengthSum = 0.0

        val sliders = ArrayList<CircularSlider>(polygon.points.size)

        fun addCornerAtBeginningOf(edge: Segment) {
            sliders.add(perimeterSlider(lengthSum))
            lengthSum += edge.length
        }

        /**
         * Creates a slider on this polygon.
         * @param lengthSum Summary length of the part of perimeter
         * from the beginning of the polygon to some point.
         */
        private fun perimeterSlider(lengthSum: Double): CircularSlider =
            CircularSlider(lengthSum / perimeter)
    }
}

