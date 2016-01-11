package org.tendiwa.plane.geometry.vectors

import org.tendiwa.plane.geometry.sectors.Sector

/**
 * Sector between two vectors.
 * @throws IllegalArgumentException If one of arguments is a
 * [zero vector|Vector.isZero].
 */
data class VectorSector(
    val cw: Vector,
    val ccw: Vector
) : Sector {
    init {
        if (cw.isZero) {
            throw IllegalArgumentException(
                "Can't use zero vector"
            );
        }
        if (ccw.isZero) {
            throw IllegalArgumentException(
                "Can't use zero vector"
            );
        }
    }

    /**
     * Checks if a vector is in a sector between two vectors.
     * @param cw Vector on the clockwise end of the sector.
     * @param ccw Vector on the counter-clockwise end of the sector.
     */
    override fun contains(vector: Vector): Boolean =
        if (cw.makesReflexAngle(ccw)) {
            ccw.perpDotProduct(vector) >= 0 && vector.perpDotProduct(cw) >= 0;
        } else {
            cw.perpDotProduct(vector) <= 0 || vector.perpDotProduct(ccw) <= 0;
        }
}
