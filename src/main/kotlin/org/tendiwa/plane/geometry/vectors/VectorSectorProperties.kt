package org.tendiwa.plane.geometry.vectors

import org.tendiwa.math.angles.AngularMeasure

// TODO: Replace Vector with Ray or Direction. A bisector is not a vector.
val VectorSector.bisector: Vector
    get() = if (ccw.makesReflexAngle(cw)) sumVector.reversed else sumVector

val VectorSector.sumVector: Vector
    get() {
        var bisectorDirection = cw.normalized + ccw.normalized;
        if (bisectorDirection.isZero) {
            bisectorDirection = ccw.rotatedQuarterCCW;
        }
        return bisectorDirection.normalized * averageMagnitude(cw, ccw)
    }

// TODO: Replace with (cw.magnitude + ccw.magnitude) / 2
private fun averageMagnitude(cw: Vector, ccw: Vector): Double =
    cw.magnitude / 2 + ccw.magnitude / 2

val VectorSector.angularMeasure: AngularMeasure
    get() = cw.direction.counterClockwiseAngle(ccw.direction)
