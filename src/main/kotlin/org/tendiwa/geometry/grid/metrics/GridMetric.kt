package org.tendiwa.geometry.grid.metrics

import org.tendiwa.geometry.grid.directions.CardinalDirection
import org.tendiwa.geometry.grid.directions.Direction
import org.tendiwa.geometry.grid.directions.OrdinalDirection

enum class GridMetric(val directions: List<Direction>) {
    KING(
        listOf(
            CardinalDirection.N,
            OrdinalDirection.NE,
            CardinalDirection.E,
            OrdinalDirection.SE,
            CardinalDirection.S,
            OrdinalDirection.SW,
            CardinalDirection.W,
            OrdinalDirection.NW
        )
    ),
    TAXICAB(
        listOf(
            CardinalDirection.N,
            CardinalDirection.E,
            CardinalDirection.S,
            CardinalDirection.W
        )
    );

    /**
     * Array of signums ([Integer.signum]) corresponding to this
     * metric's directions, sorted clockwise starting from
     * [CardinalDirection.N].
     */
    val signums: Array<Pair<Int, Int>> = directions
        .map { Pair(it.dx, it.dy) }
        .toTypedArray()

}
