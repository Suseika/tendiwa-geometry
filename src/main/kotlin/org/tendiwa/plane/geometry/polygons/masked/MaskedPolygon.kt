package org.tendiwa.plane.geometry.polygons.masked

import org.tendiwa.math.integers.even
import org.tendiwa.math.integers.odd
import org.tendiwa.math.sliders.CircularMask
import org.tendiwa.math.sliders.borders
import org.tendiwa.math.sliders.contains0
import org.tendiwa.plane.geometry.polygons.Polygon
import org.tendiwa.plane.geometry.polygons.cut.cut
import org.tendiwa.plane.geometry.polygons.cut.disjoin
import org.tendiwa.plane.geometry.polylines.Polyline
import org.tendiwa.tools.argumentConstraint

/**
 * Border of a polygon partitioned into two kinds of polylines: [masked] and
 * [unmasked].
 */
data class MaskedPolygon
internal constructor(
    val masked: List<Polyline>,
    val unmasked: List<Polyline>
)

/**
 * Partitions the border of the polygon into two kinds of fragments: ones that
 * are covered by a mask, and the rest of the polygon's border.
 *
 * @param mask Circular mask.
 */
fun Polygon.mask(mask: CircularMask): MaskedPolygon {
    argumentConstraint(
        mask.combinedSpheres,
        { it.isNotEmpty() },
        { "The list of combined spheres in the mask must be non-empty" }
    )
    return mask
        .borders()
        .let { it.sortedBy { it.position } }
        .let { this@mask.cut(it).disjoin() }
        .let {
            MaskedPolygon(
                masked = it.filterIndexed {
                    i, polyline ->
                    if (mask.contains0()) i.odd else i.even
                },
                unmasked = it.filterIndexed {
                    i, polyline ->
                    if (mask.contains0()) i.even else i.odd
                }
            )
        }
}
