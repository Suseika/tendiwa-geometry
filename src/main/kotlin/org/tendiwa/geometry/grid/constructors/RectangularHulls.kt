package org.tendiwa.geometry.grid.constructors

import org.tendiwa.geometry.grid.gridSegments.GridSegment
import org.tendiwa.geometry.grid.gridSegments.end
import org.tendiwa.geometry.grid.gridSegments.start
import org.tendiwa.geometry.grid.rectangles.GridRectangle
import org.tendiwa.math.integers.segmentLength

/**
 * Smallest possible axis-parallel rectangle that contains all tiles of a
 * [GridSegment].
 */
val GridSegment.rectangularHull: GridRectangle
    get() =
    GridRectangle(
        Math.min(this.start.x, this.end.x),
        Math.min(this.start.y, this.end.y),
        this.start.x segmentLength this.end.x,
        this.start.y segmentLength this.end.y
    )

