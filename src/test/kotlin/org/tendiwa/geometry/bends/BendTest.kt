package org.tendiwa.geometry.bends

import org.junit.Test
import org.tendiwa.geometry.points.AnyPoint
import org.tendiwa.geometry.points.move
import org.tendiwa.geometry.points.moveHorizontally
import org.tendiwa.geometry.points.moveVertically
import org.tendiwa.plane.directions.OrdinalDirection.NE
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
                    this.move(NE, 1.0),
                    this.move(NE, 2.0)
                ).isStraight
            )
        }
    }

    @Test fun canBeNotStraight() {
        AnyPoint().apply {
            assertFalse(
                Bend(
                    this,
                    this.move(NE, 1.0),
                    this.moveHorizontally(1.0)
                ).isStraight
            )
        }
    }
}
