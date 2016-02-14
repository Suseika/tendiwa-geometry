package org.tendiwa.plane.geometry.polygons.cut

import org.tendiwa.collections.circularSubList
import org.tendiwa.collections.loopedLinks
import org.tendiwa.plane.geometry.paths.SegmentPath
import org.tendiwa.plane.geometry.polylines.Polyline
import org.tendiwa.tools.argumentsConstraint
import java.util.*

/**
 * Disjoins this cut polygon at cut points into [Polyline]s.
 * @return Polylines of points of this polygon, with the start of first
 * polyline being at the first cut point, and the rest of polylines going
 * polygonwise.
 * @throws IllegalArgumentException If there are 0 or an odd number of cuts.
 */
fun CutPolygon.disjoin(): List<SegmentPath> {
    argumentsConstraint(
        !cuts.isEmpty() && cuts.size % 2 == 0,
        {
            "CutPolygon should contain an even number of cuts that is > 0;" +
                "CutPolygon has ${cuts.size} cuts"
        }
    )
    val polygon = this.toPolygon()
    return cutsIndices()
        .loopedLinks
        .map { polygon.points.circularSubList(it.first, it.second+1) }
        .map { Polyline(it) }
}

private fun CutPolygon.cutsIndices(): List<Int> {
    val indices = ArrayList<Int>(cuts.size)
    var cutIndex = 0
    val points = this.toPolygon().points
    points.forEachIndexed {
        i, point ->
        if (cutIndex < cuts.size && point == cuts[cutIndex]) {
            indices.add(i)
            cutIndex++
        }
    }
    return indices
}

