package org.tendiwa.plane.geometry.polygons.sliders

import org.tendiwa.collections.nextAfter

/**
 * Edges of this polygon in circular slider form, ordered polygonwise.
 */
val SliderPolygon.edges: List<SliderPolygonEdge>
    get() =
    sliders
        .indices
        .map {
            SliderPolygonEdge(
                start = sliders[it],
                end = sliders.nextAfter(it),
                segment = original.segments[it]
            )
        }
