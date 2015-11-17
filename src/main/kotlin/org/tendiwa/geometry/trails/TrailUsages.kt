package org.tendiwa.geometry.trails

import org.tendiwa.geometry.polylines.Polyline
import org.tendiwa.geometry.polygons.Polygon

val Trail.polygon: Polygon
    get() = Polygon(points)

val Trail.polyline: Polyline
    get() = Polyline(points)
