package org.tendiwa.geometry.continuum.polygons

import org.tendiwa.geometry.continuum.rectangles.Rectangle
import org.tendiwa.geometry.continuum.rectangles.rectangleFromRanges

/**
 * Returns the minimum rectangle that contains all points of a polygon.
 * @return The bounding rectangle of a polygon.
 */
val Polygon.rectangularHull: Rectangle
    get() =
    rectangleFromRanges(
        this.points.minBy { it.x }!!.x,
        this.points.maxBy { it.x }!!.x,
        this.points.minBy { it.y }!!.y,
        this.points.maxBy { it.y }!!.y
    )
