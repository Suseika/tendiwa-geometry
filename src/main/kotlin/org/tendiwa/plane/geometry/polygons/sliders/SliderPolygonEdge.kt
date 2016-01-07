package org.tendiwa.plane.geometry.polygons.sliders

import org.tendiwa.math.sliders.CircularSlider
import org.tendiwa.math.sliders.alternativePosition
import org.tendiwa.math.sliders.goesBefore
import org.tendiwa.plane.geometry.points.Point
import org.tendiwa.plane.geometry.points.move
import org.tendiwa.plane.geometry.segments.Segment
import org.tendiwa.plane.geometry.segments.vector
import org.tendiwa.plane.geometry.vectors.Vector
import org.tendiwa.plane.geometry.vectors.times

/**
 * Segment and its position on the perimeter of a polygon.
 * @param segment A segment of a polygon.
 * @param start Position of the segment's start in slider form
 * @param end Position of the segment's end in slider form.
 */
data class SliderPolygonEdge(
    val segment: Segment,
    val start: CircularSlider,
    val end: CircularSlider
) {
    init {
        assert(start goesBefore end)
    }

    fun point2D(polygonSlider: CircularSlider): Point =
        segment
            .start
            .move(fromBeginningToPoint(polygonSlider))

    /**
     * Length of this polygon is [CircularSlider] coordinates.
     */
    private val circularLength: Double
        get() = end.alternativePosition - start.position

    private fun fromBeginningToPoint(
        polygonSlider: CircularSlider
    ): Vector =
        segment.vector * ((polygonSlider.position - start.position) / circularLength)
}
