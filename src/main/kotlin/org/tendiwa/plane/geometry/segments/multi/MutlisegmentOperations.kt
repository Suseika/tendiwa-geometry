package org.tendiwa.plane.geometry.segments.multi

import org.tendiwa.plane.geometry.points.move
import org.tendiwa.plane.geometry.points.vectorTo
import org.tendiwa.plane.geometry.rays.Ray
import org.tendiwa.plane.geometry.vectors.VectorSector
import org.tendiwa.plane.geometry.vectors.bisector
import org.tendiwa.plane.geometry.vectors.direction

/**
 * Returns a ray that is
 * - normal to the bisegment;
 * - starting from the [Bisegment.cut];
 * - faces left from the bisegment.
 */
fun Bisegment.leftNormal(): Ray {
    val cwPoint = original.end
    val ccwPoint = original.start
    val rayStart = cut
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
