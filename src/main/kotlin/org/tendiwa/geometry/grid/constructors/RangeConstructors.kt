package org.tendiwa.geometry.grid.constructors

import org.tendiwa.geometry.grid.segments.GridSegment
import org.tendiwa.geometry.grid.rectangles.GridRectangle
import org.tendiwa.geometry.grid.tiles.Tile
import org.tendiwa.math.integers.segmentLength

infix fun Tile.segmentTo(end: Tile): GridSegment =
    GridSegment(this, end)

/**
 * Creates a rectangle defined by diagonally opposite corners, similar to how
 * you select multiple units in strategy games.
 */
infix fun Tile.rectangleTo(another: Tile): GridRectangle =
    GridRectangle(
        Math.min(this.x, another.x),
        Math.min(this.y, another.y),
        this.x segmentLength another.x,
        this.y segmentLength another.y
    )
