package org.tendiwa.geometry.grid.constructors

import org.tendiwa.geometry.grid.gridSegments.GridSegment
import org.tendiwa.geometry.grid.gridSegments.end
import org.tendiwa.geometry.grid.gridSegments.start
import org.tendiwa.geometry.grid.rectangles.GridRectangle
import org.tendiwa.geometry.grid.tiles.Tile
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

val Iterable<Tile>.rectangularHull: GridRectangle
    get() {
        var minX = this.first().x
        var minY = this.first().y
        var maxX = this.first().x
        var maxY = this.first().y
        for (tile in this) {
            if (tile.x < minX) {
                minX = tile.x
            } else if (tile.x > maxX) {
                maxX = tile.x
            }
            if (tile.y < minY) {
                minY = tile.y
            } else if (tile.y > maxY) {
                maxY = tile.y
            }
        }
        return GridRectangle(
            minX,
            minY,
            minX segmentLength maxX,
            minY segmentLength maxY
        )
    }
