package org.tendiwa.plane.geometry.angles

import org.tendiwa.math.angles.AngularMeasure
import org.tendiwa.plane.directions.Direction
import org.tendiwa.plane.directions.RadianDirection
import org.tendiwa.plane.geometry.points.Point
import org.tendiwa.plane.geometry.rays.Ray
import org.tendiwa.tools.butIf
import java.lang.Math.PI

/**
 * Figure formed by two rays, called the sides of the angle.
 */
data class Angle
/**
 * @param point Beginning of both rays.
 * @param cw Direction of the clockwise ray.
 * @param ccw Direction of the counter-clockwise ray.
 */
(
    val point: Point,
    val cw: Direction,
    val ccw: Direction
)

val Angle.measure: AngularMeasure
    get() = cw.counterClockwiseAngle(ccw)

val Angle.bisector: Ray
    get() = Ray(
        point,
        ccw.radians
            .butIf(
                { it < cw.radians },
                { it + PI * 2 }
            )
            .let { (it + cw.radians) / 2 }
            .let { RadianDirection(it) }
    )

private fun Angle.isTranszero(): Boolean =
    cw.radians > ccw.radians

fun Angle.contains(direction: Direction): Boolean {
    val isTranszero = isTranszero()
    val orderedCcwRadians = ccw.radians
        .butIf(
            { isTranszero },
            { it + PI * 2 }
        )
    val orderedTargetRadians = direction.radians
        .butIf(
            { it < cw.radians },
            { it + PI * 2 }
        )
    return orderedTargetRadians >= cw.radians
        && orderedTargetRadians <= orderedCcwRadians
}
