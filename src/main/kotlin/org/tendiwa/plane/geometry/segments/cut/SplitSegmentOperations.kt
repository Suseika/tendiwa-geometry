package org.tendiwa.plane.geometry.segments.cut

import org.tendiwa.plane.geometry.points.move
import org.tendiwa.plane.geometry.points.vectorTo
import org.tendiwa.plane.geometry.rays.Ray
import org.tendiwa.plane.geometry.vectors.VectorSector
import org.tendiwa.plane.geometry.vectors.bisector
import org.tendiwa.plane.geometry.vectors.direction

/**
 * Returns a ray that is
 * - normal to the split segment;
 * - starting from the [SplitSegment.middlePoint];
 * - faces left from the split segment.
 */
fun SplitSegment.leftNormal(): Ray {
    val cwPoint = originalSegment.end
    val ccwPoint = originalSegment.start
    val rayStart = middlePoint
    val pointOnRay = rayStart.move(
        VectorSector(
            rayStart.vectorTo(cwPoint),
            rayStart.vectorTo(ccwPoint)
        ).bisector
    );
    return Ray(
        rayStart,
        rayStart.vectorTo(pointOnRay).direction
    );
}
