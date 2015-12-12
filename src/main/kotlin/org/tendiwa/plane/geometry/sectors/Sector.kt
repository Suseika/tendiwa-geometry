package org.tendiwa.plane.geometry.sectors

import org.tendiwa.plane.geometry.vectors.Vector

interface Sector {
    fun contains(vector: Vector): Boolean
}
