package org.tendiwa.plane.geometry.vectors

import org.tendiwa.math.doubles.toPositiveZero

/**
 * Replaces -0.0 in x and y components of this vector with 0.0.
 */
fun Vector.toPositiveZeroVector(): Vector =
    Vector(
        if (x == 0.0) {
            x.toPositiveZero()
        } else {
            x
        },
        if (y == 0.0) {
            y.toPositiveZero()
        } else {
            y
        }
    )
