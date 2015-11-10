package org.tendiwa.geometry.grid.rectangles.sides

import org.tendiwa.geometry.grid.constructors.segmentTo
import org.tendiwa.geometry.grid.directions.CardinalDirection
import org.tendiwa.geometry.grid.directions.OrdinalDirection
import org.tendiwa.geometry.grid.rectangles.GridRectangle
import org.tendiwa.geometry.grid.rectangles.corner
import org.tendiwa.geometry.grid.segments.GridSegment

fun GridRectangle.side(side: CardinalDirection): GridSegment =
    when (side) {
        CardinalDirection.N ->
            cornerToCorner(
                OrdinalDirection.NW,
                OrdinalDirection.NE
            )
        CardinalDirection.E -> cornerToCorner(
            OrdinalDirection.NE,
            OrdinalDirection.SE
        )
        CardinalDirection.S -> cornerToCorner(
            OrdinalDirection.SW,
            OrdinalDirection.SE
        )
        CardinalDirection.W -> cornerToCorner(
            OrdinalDirection.NW,
            OrdinalDirection.SW
        )
    }

private fun GridRectangle.cornerToCorner(
    a: OrdinalDirection,
    b: OrdinalDirection
) =
    corner(a) segmentTo corner(b)

