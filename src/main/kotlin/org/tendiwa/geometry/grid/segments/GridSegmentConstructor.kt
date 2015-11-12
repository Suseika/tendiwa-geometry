package org.tendiwa.geometry.grid.segments

import org.tendiwa.geometry.grid.constructors.rectangleTo
import org.tendiwa.geometry.grid.rectangles.GridRectangle
import org.tendiwa.geometry.grid.tiles.Tile
import java.util.*


fun GridSegment(start: Tile, end: Tile): GridSegment =
    object : GridSegment {
        override val start = start
        override val end = end
        override val hull: GridRectangle
            get() = start rectangleTo end

        override val tiles: Set<Tile> by lazy {
            tilesList.toSet()
        }

        override val tilesList: List<Tile>
            get() = bresenhamLine(start, end)

        override fun contains(x: Int, y: Int): Boolean =
            tiles.contains(Tile(x, y))

        /**
         * Implementation of
         * [Bresenham line algorithm](https://en.wikipedia.org/wiki/Bresenham%27s_line_algorithm)
         */
        private fun bresenhamLine(start: Tile, end: Tile): List<Tile> {
            val w = end.x - start.x
            val h = end.y - start.y
            val dx1 = Integer.signum(w)
            var dx2 = Integer.signum(w)
            val dy1 = Integer.signum(h);
            var dy2 = 0;
            var longest = Math.abs(w);
            var shortest = Math.abs(h);
            if (!(longest > shortest)) {
                val tmp = longest
                longest = shortest
                shortest = tmp
                dy2 = Integer.signum(h);
                dx2 = 0;
            }
            val line = ArrayList<Tile>(longest)
            var numerator = longest shr 1
            var x = start.x
            var y = start.y
            for (i in 0..longest) {
                line.add(Tile(x, y))
                numerator += shortest
                if (numerator >= longest) {
                    numerator -= longest
                    x += dx1
                    y += dy1
                } else {
                    x += dx2
                    y += dy2
                }
            }
            return line
        }
    }
