package org.tendiwa.plane.geometry.bends

import org.junit.Test
import org.tendiwa.plane.directions.OrdinalDirection.NE
import org.tendiwa.plane.geometry.points.AnyPoint
import org.tendiwa.plane.geometry.points.moveHorizontally
import org.tendiwa.plane.geometry.points.moveKing
import org.tendiwa.plane.geometry.points.moveVertically
import kotlin.test.assertFalse

class BendTest {
    @Test fun canBeStraight() {
        AnyPoint().apply {
            assert(
                Bend(
                    this,
                    this.moveHorizontally(1.0),
                    this.moveHorizontally(2.0)
                ).isStraight
            )
        }
        AnyPoint().apply {
            assert(
                Bend(
                    this,
                    this.moveVertically(1.0),
                    this.moveVertically(2.0)
                ).isStraight
            )
        }
        AnyPoint().apply {
            assert(
                Bend(
                    this,
                    this.moveKing(NE, 1.0),
                    this.moveKing(NE, 2.0)
                ).isStraight
            )
        }
    }

    @Test fun canBeNotStraight() {
        AnyPoint().apply {
            assertFalse(
                Bend(
                    this,
                    this.moveKing(NE, 1.0),
                    this.moveHorizontally(1.0)
                ).isStraight
            )
        }
    }
}
