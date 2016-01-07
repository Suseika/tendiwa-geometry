package org.tendiwa.plane.geometry.corners

import org.tendiwa.plane.geometry.points.Point
import org.tendiwa.plane.geometry.points.vectorTo
import org.tendiwa.plane.geometry.vectors.VectorSector

data class Corner(val point: Point, val sector: VectorSector) {
    /**
     * Creates a [Corner] in point [b].
     * @param a Point before corner
     * @param b Point at corner
     * @param c Point after corner
     * @param right Whether the sector of corner is right from `Polyline(a,b,c)`
     * or left.
     */
    constructor(a: Point, b: Point, c: Point, right: Boolean) : this(
        point = b,
        sector = VectorSector(
            cw = b vectorTo if (right) a else c,
            ccw = b vectorTo if (right) c else a
        )
    )
}

