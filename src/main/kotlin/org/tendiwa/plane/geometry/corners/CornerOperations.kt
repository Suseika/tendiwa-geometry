package org.tendiwa.plane.geometry.corners

import org.tendiwa.plane.geometry.rays.Ray
import org.tendiwa.plane.geometry.vectors.bisector
import org.tendiwa.plane.geometry.vectors.direction

val Corner.bisector: Ray
    get() =
    Ray(point, sector.bisector.direction)
