package org.tendiwa.plane.geometry.segments.multi

import org.junit.Test
import org.tendiwa.plane.geometry.segments.ANY
import org.tendiwa.plane.geometry.segments.Segment
import org.tendiwa.plane.geometry.segments.slider

class BisegmentTest {
    @Test
    fun leftNormalFacesLeft() {
        Segment.ANY
            .run { Bisegment(this, this.slider(0.4)) }
            .leftNormal()
    }
}
