package org.tendiwa.plane.geometry.polygons.cut

import org.tendiwa.plane.geometry.polygons.Polygon

/**
 * Creates a polygon whose points are both points of the [CutPolygon.original]
 * polygon and [CutPolygon.cutsOnSubsegment]s, ordered polygonwise in the
 * relation to the [CutPolygon.original] polygon.
 */
fun CutPolygon.toPolygon(): Polygon =
    Polygon(
        original.segments
            .flatMap { listOf(it.start) + cutsOnSubsegment(it) }
    )
