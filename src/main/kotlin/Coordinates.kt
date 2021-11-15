import kotlin.math.pow
import kotlin.math.sqrt

data class Coordinates(val x: Double, val y: Double)
{
    // Returns the distance from this point to the target
    fun distanceToTarget(target: Coordinates): Double
    {
        return roundToDecimalPlaces(sqrt((x - target.x).pow(2) + (y - target.y).pow(2)), 4)
    }
}