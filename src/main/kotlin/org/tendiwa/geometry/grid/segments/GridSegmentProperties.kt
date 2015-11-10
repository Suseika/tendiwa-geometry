package org.tendiwa.geometry.grid.segments

import org.tendiwa.geometry.grid.tiles.Tile

val GridSegment.start: Tile
    get() = this.tiles.first()

val GridSegment.end: Tile
    get() = this.tiles.last()

