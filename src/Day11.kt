import kotlin.math.roundToInt
import kotlin.math.sqrt

object Day11 {

    private val halfSqrt3 = sqrt(3.0) / 2.0
    private val directions = mapOf(
            "n" to Pair(0.0, 1.0),
            "ne" to Pair(halfSqrt3, 0.5),
            "se" to Pair(halfSqrt3, -0.5),
            "s" to Pair(0.0, -1.0),
            "sw" to Pair(-halfSqrt3, -0.5),
            "nw" to Pair(-halfSqrt3, 0.5))

    fun part1(input: String) = input
            .split("[^a-z]+".toRegex())
            .map { directions[it] ?: Pair(0.0, 0.0) }
            .reduce { acc, direction -> acc + direction }
            .let {
                distanceFromCenter(it)
            }

    private fun distanceFromCenter(position: Pair<Double, Double>): Int {
        val sideStep = position.first / halfSqrt3
        return (Math.abs(sideStep) + Math.max(0.0, Math.abs(position.second) - Math.abs(0.5 * sideStep))).roundToInt()
    }

    fun part2(input: String): Int {
        var position = Pair(0.0, 0.0)
        var max = 0
        input.split("[^a-z]+".toRegex())
                .map { directions[it] ?: Pair(0.0, 0.0) }
                .onEach { direction ->
                    position += direction
                    max = Math.max(max, distanceFromCenter(position))
                }
        return max
    }
}

private operator fun Pair<Double, Double>.plus(pair: Pair<Double, Double>) = Pair(first + pair.first, second + pair.second)

