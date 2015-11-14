package org.tendiwa.geometry.grid.segments.ortho

import org.tendiwa.geometry.grid.rectangles.GridRectangle
import org.tendiwa.geometry.grid.tiles.Tile
import org.tendiwa.geometry.grid.tiles.move

data class HorizontalGridSegment(
    override val start: Tile,
    private val length: Int
) : OrthoGridSegment {
    override val end: Tile
        get() = start.move(length - 1, 0)

    override val endX: Int
        get() = start.x + length - 1

    override val endY: Int
        get() = start.y

    override val tilesList: List<Tile>
        get() = (0 until length).map { dx -> start.move(dx, 0) }

    override val hull: GridRectangle
        get() = GridRectangle(start.x, start.y, length, 1)

    override fun contains(x: Int, y: Int): Boolean =
        y == start.y && x in (start.x until start.x + length)
}
