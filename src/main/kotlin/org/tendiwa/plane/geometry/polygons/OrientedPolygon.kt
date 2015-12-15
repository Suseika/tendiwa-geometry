package org.tendiwa.plane.geometry.polygons

import org.tendiwa.plane.geometry.segments.Segment

/**
 * Polygon that knows if its points go clockwise or counter-clockwise.
 */
interface OrientedPolygon : Polygon {
    /**
     * Checks if a segment of this polygon is oriented clockwise.
     * @param segment A segment of this polygon.
     */
    fun isSegmentClockwise(segment: Segment): Boolean
}
