package org.tendiwa.geometry.grid.segments.ortho

import org.tendiwa.geometry.grid.rectangles.GridRectangle
import org.tendiwa.geometry.grid.tiles.Tile
import org.tendiwa.geometry.grid.tiles.move

data class VerticalGridSegment(
    override val start: Tile,
    private val length: Int
) : OrthoGridSegment {
    override val end: Tile
        get() = start.move(0, length - 1)

    override val endX: Int
        get() = start.x

    override val endY: Int
        get() = start.y + length - 1

    override val tilesList: List<Tile>
        get() = (0 until length).map { dy -> start.move(0, dy) }

    override val hull: GridRectangle
        get() = GridRectangle(start.x, start.y, 1, length)

    override fun contains(x: Int, y: Int): Boolean =
        x == start.x && y in (start.y until start.y + length)
}
