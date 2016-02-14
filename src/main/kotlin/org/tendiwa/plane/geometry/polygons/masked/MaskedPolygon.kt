package org.tendiwa.plane.geometry.polygons.masked

import org.tendiwa.math.integers.even
import org.tendiwa.math.integers.odd
import org.tendiwa.math.sliders.*
import org.tendiwa.plane.geometry.paths.SegmentPath
import org.tendiwa.plane.geometry.polygons.Polygon
import org.tendiwa.plane.geometry.polygons.cut.cut
import org.tendiwa.plane.geometry.polygons.cut.disjoin

/**
 * Border of a polygon partitioned into two kinds of polylines: [masked] and
 * [unmasked].
 */
data class MaskedPolygon
internal constructor(
    val masked: List<SegmentPath>,
    val unmasked: List<SegmentPath>
)

/**
 * Partitions the border of the polygon into two kinds of fragments: ones that
 * are covered by a mask, and the rest of the polygon's border.
 *
 * @param mask Circular mask.
 */
fun Polygon.mask(mask: CircularMask): MaskedPolygon =
    mask
        .borders()
        .let { it.sortedBy { it.position } }
        .let { this@mask.cut(it).disjoin() }
        .let {
            when {
                mask.isOmnipresent() ->
                    MaskedPolygon(
                        masked = it,
                        unmasked = emptyList()
                    )
                mask.isEmpty() ->
                    MaskedPolygon(
                        masked = emptyList(),
                        unmasked = it
                    )
                else ->
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
