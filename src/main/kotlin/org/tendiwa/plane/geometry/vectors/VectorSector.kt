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

    override fun contains(vector: Vector): Boolean =
        vector.isBetweenVectors(cw, ccw)
}
