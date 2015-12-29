package org.tendiwa.plane.geometry.polygons.cut

import org.junit.Rule
import org.junit.Test
import org.junit.rules.ExpectedException
import org.tendiwa.math.constants.EPSILON
import org.tendiwa.plane.directions.CardinalDirection
import org.tendiwa.plane.geometry.points.Point
import org.tendiwa.plane.geometry.points.distanceTo
import org.tendiwa.plane.geometry.rectangles.Rectangle
import org.tendiwa.plane.geometry.rectangles.side
import kotlin.test.assertEquals

class CutPolygonTest {
    @JvmField @Rule val expectRule = ExpectedException.none()

    val rectangle = Rectangle(0.0, 0.0, 10.0, 10.0)
    val cutRectangle = rectangle.cut(0.0, 0.25, 0.5, 0.75)

    @Test
    fun canHaveCutsOnBothCornersAndEdges() {
        rectangle.cut(0.0, 0.12, 0.25, 0.37, 0.5, 0.62, 0.75, 0.87, 0.94)
            .apply { assertEquals(9, cuts.size) }
    }

    @Test
    fun cuttingAtCornersDoesntCutEdges() {
        cutRectangle
            .apply {
                assertEquals(
                    0,
                    original.segments
                        .flatMap { cutsOnSubsegment(it) }
                        .size
                )
            }
    }

    @Test
    fun cuttingAtCornersAddsCuts() {
        cutRectangle.apply { assertEquals(4, cuts.size) }
    }

    @Test
    fun edgeCanBeCutIntoMultipleSegments() {
        rectangle.cut(0.1, 0.15, 0.20)
            .cutsOnSubsegment(rectangle.segments[0])
            .apply { assertEquals(3, size) }
    }

    @Test
    fun allows0Cuts() {
        rectangle.cut(emptyList())
            .apply { assertEquals(0, cuts.size) }
    }

    @Test
    fun failsIfCutsAreNotSorted() {
        expectRule.expect(IllegalArgumentException::class.java)
        expectRule.expectMessage(
            "cutPositions must be sorted in ascending order"
        )
        rectangle.cut(0.2, 0.8, 0.5)
    }

    @Test
    fun failsIfCutsAreOutsideAllowedRange() {
        expectRule.expect(IllegalArgumentException::class.java)
        expectRule.expectMessage("position must be in [0..1)")
        rectangle.cut(-0.5, 0.1, 0.4, 0.6, 0.66, 1.0)
    }

    @Test
    fun cutsOnSubsegmentsAreAtCorrectPositions() {
        val rectangle = Rectangle(0.0, 0.0, 10.0, 10.0)
        val cut = rectangle.cut(0.2, 0.5, 0.6, 0.7)
        CardinalDirection.values()
            .flatMap { cut.cutsOnSubsegment(rectangle.side(it)) }
            .zip (
                listOf(
                    Point(8.0, 0.0),
                    Point(6.0, 10.0),
                    Point(2.0, 10.0)
                )
            )
            .apply { assertEquals(3, size) }
            .forEach {
                assert(
                    it.first distanceTo it.second < EPSILON,
                    { it }
                )
            }
    }
}
