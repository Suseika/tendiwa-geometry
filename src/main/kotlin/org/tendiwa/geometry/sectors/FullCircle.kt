package org.tendiwa.geometry.sectors

import org.tendiwa.geometry.vectors.Vector

class FullCircle : Sector {
    override fun contains(vector: Vector): Boolean =
        true
}

