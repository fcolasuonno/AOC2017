object Day03 {

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
        var acc = 1
        matrix[Pair(0, 0)] = acc
        pairGenerator.asIterable().takeWhile { current ->
            acc = matrix.getOrDefault(current.copy(current.first + 1, current.second + 1), 0) +
                    matrix.getOrDefault(current.copy(current.first, current.second + 1), 0) +
                    matrix.getOrDefault(current.copy(current.first - 1, current.second + 1), 0) +
                    matrix.getOrDefault(current.copy(current.first - 1, current.second), 0) +
                    matrix.getOrDefault(current.copy(current.first - 1, current.second - 1), 0) +
                    matrix.getOrDefault(current.copy(current.first, current.second - 1), 0) +
                    matrix.getOrDefault(current.copy(current.first + 1, current.second - 1), 0) +
                    matrix.getOrDefault(current.copy(current.first + 1, current.second), 0)
            matrix[current] = acc
            acc <= input
        }
        return acc
    }

    val pairGenerator: Sequence<Pair<Int, Int>> = generateSequence(Pair(1, 0)) {
        val corner = Math.max(Math.abs(it.first), Math.abs(it.second))
        if (it.first == corner && it.second == -corner) {
            Pair(it.first + 1, it.second)
        } else {
            val x_increment = when (it.first) {
                corner -> when (it.second) {
                    corner -> -1
                    -corner -> 0
                    else -> 0
                }
                -corner -> when (it.second) {
                    -corner -> 1
                    else -> 0
                }
                else -> when (it.second) {
                    corner -> -1
                    else -> 1
                }
            }
            val y_increment = when (it.second) {
                corner -> when (it.first) {
                    -corner -> -1
                    else -> 0
                }
                -corner -> when (it.first) {
                    corner -> 1
                    else -> 0
                }
                else -> when (it.first) {
                    corner -> 1
                    else -> -1
                }
            }
            Pair(it.first + x_increment, it.second + y_increment)
        }
    }
}

