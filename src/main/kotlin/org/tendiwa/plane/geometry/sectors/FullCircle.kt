package org.tendiwa.plane.geometry.sectors

import org.tendiwa.plane.geometry.vectors.Vector

class FullCircle : Sector {
    override fun contains(vector: Vector): Boolean =
        true
}

