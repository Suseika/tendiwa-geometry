package org.tendiwa.geometry.grid.segments

import org.tendiwa.geometry.grid.tiles.Tile
import org.tendiwa.math.integers.odd

val GridSegment.dx: Int
    get() = end.x - start.x

val GridSegment.dy: Int
    get() = end.y - start.y

val GridSegment.middle: Tile
    get() {
        if (dx.odd || dy.odd) {
            throw IllegalArgumentException(
                "In order to obtain GridSegment's middle, the segment should " +
                    "have even dx and dy. Current segment has dx=$dx and dy=$dy"
            )
        }
        return Tile(
            start.x + dx / 2,
            start.y + dy / 2
        )
    }


