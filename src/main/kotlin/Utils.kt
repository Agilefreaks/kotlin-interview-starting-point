import kotlin.math.pow
import kotlin.math.round

fun roundToDecimalPlaces(number: Double, decimals: Int): Double
{
    val factor: Double = 10.0.pow(decimals)
    return round(number * factor) / factor
}