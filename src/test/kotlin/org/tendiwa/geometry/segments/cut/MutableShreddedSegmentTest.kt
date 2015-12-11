package org.tendiwa.geometry.segments.cut

import org.junit.Rule
import org.junit.Test
import org.junit.rules.ExpectedException
import org.tendiwa.geometry.segments.ANY
import org.tendiwa.geometry.segments.Segment
import org.tendiwa.geometry.segments.slider
import kotlin.test.assertEquals

class MutableShreddedSegmentTest {
    @JvmField @Rule val expectRule = ExpectedException.none()

    @Test
    fun splitsMutlipleTimes() {
        Segment.ANY
            .run {
                MutableShreddedSegment(this)
                    .apply {
                        splitAt(slider(0.7))
                        splitAt(slider(0.4))
                        splitAt(slider(0.1))
                    }
            }
            .apply {
                assertEquals(4, parts.size)
                assertEquals(3, cuts.size)
            }
    }

    @Test
    fun splitAtEndpoint() {
        expectRule.expect(IllegalArgumentException::class.java)
        expectRule.expectMessage("an endpoint of the segment")
        Segment.ANY
            .run {
                MutableShreddedSegment(this)
                    .apply { splitAt(start) }
            }
    }

    @Test
    fun splitAtSamePointTwice() {
        expectRule.expect(IllegalArgumentException::class.java)
        expectRule.expectMessage("existing split point")
        Segment.ANY
            .run {
                MutableShreddedSegment(this)
                    .apply {
                        splitAt(slider(0.2))
                        splitAt(slider(0.2))
                    }
            }
    }

    @Test
    fun splitOutsideOriginalSegmentFails() {
        expectRule.expect(IllegalArgumentException::class.java)
        expectRule.expectMessage("not on segment")
        Segment.ANY
            .apply {
                MutableShreddedSegment(this).splitAt(slider(-1.0))
            }
    }
}
