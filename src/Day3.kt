class Day3 {

    fun part1(input: Int) = input.let {
        var side = 1
        while (side * side < it) {
            side += 2
        }
        val around = side * side - it
        val x_offset = around - (side - 1) - (side - 1) / 2
        val x = Math.max(-side / 2, Math.min(side / 2, Math.abs(x_offset) - (side - 1)))
        val y_offset = around - 2 * (side - 1) - (side - 1) / 2
        val y = Math.max(-side / 2, Math.min(side / 2, -Math.abs(y_offset) + (side - 1)))
        Math.abs(x) + Math.abs(y)
    }

    fun part2(input: Int): Int {
        val matrix = mutableMapOf<Pair<Int, Int>, Int>()
        var current = Pair(0, 0)
        matrix[current] = 1
        var acc = 0
        while (acc <= input) {
            current++
            acc = matrix.getOrDefault(current.copy(current.first + 1, current.second + 1), 0) +
                    matrix.getOrDefault(current.copy(current.first, current.second + 1), 0) +
                    matrix.getOrDefault(current.copy(current.first - 1, current.second + 1), 0) +
                    matrix.getOrDefault(current.copy(current.first - 1, current.second), 0) +
                    matrix.getOrDefault(current.copy(current.first - 1, current.second - 1), 0) +
                    matrix.getOrDefault(current.copy(current.first, current.second - 1), 0) +
                    matrix.getOrDefault(current.copy(current.first + 1, current.second - 1), 0) +
                    matrix.getOrDefault(current.copy(current.first + 1, current.second), 0)
            matrix[current] = acc
        }
        return acc
    }


}

operator fun Pair<Int, Int>.inc(): Pair<Int, Int> {
    val corner = Math.max(Math.abs(first), Math.abs(second))
    if (first == 0 && second == 0) return Pair(1, 0)
    if (first == corner && second == -corner) return Pair(first + 1, second)
    val x_increment = when (first) {
        corner -> when (second) {
            corner -> -1
            -corner -> 0
            else -> 0
        }
        -corner -> when (second) {
            -corner -> 1
            else -> 0
        }
        else -> when (second) {
            corner -> -1
            else -> 1
        }
    }
    val y_increment = when (second) {
        corner -> when (first) {
            -corner -> -1
            else -> 0
        }
        -corner -> when (first) {
            corner -> 1
            else -> 0
        }
        else -> when (first) {
            corner -> 1
            else -> -1
        }
    }
    return Pair(first + x_increment, second + y_increment)
}

