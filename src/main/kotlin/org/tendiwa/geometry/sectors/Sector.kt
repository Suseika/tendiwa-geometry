package org.tendiwa.geometry.sectors

import org.tendiwa.geometry.vectors.Vector

interface Sector {
	fun contains(vector: Vector): Boolean
}
