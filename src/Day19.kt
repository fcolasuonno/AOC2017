object Day19 {
    enum class Direction {
        DOWN,
        RIGHT,
        UP,
        LEFT
    }

    fun part1(input: List<String>): String {
        var output = ""
        val map = input.map { it.toCharArray().toTypedArray() }.toTypedArray()
        val start = Pair(map[0].indexOfFirst { it == '|' }, 0)
        var dir = Direction.DOWN
        var cur = start
        var curVal = map[cur.second][cur.first]
        while (curVal != ' ') {
            if (curVal == '+') {
                dir = when (dir) {
                    Direction.DOWN,
                    Direction.UP -> if (map[cur.second][cur.first - 1] == ' ') Direction.RIGHT else Direction.LEFT
                    Direction.RIGHT,
                    Direction.LEFT -> if (map[cur.second - 1][cur.first] == ' ') Direction.DOWN else Direction.UP
                }
            }
            if (curVal.isLetter()) {
                output += curVal
            }
            cur = next(cur, dir)
            curVal = map[cur.second][cur.first]
        }
        return output
    }

    private fun next(loc: Pair<Int, Int>, direction: Direction): Pair<Int, Int> {
        val nextLoc = when (direction) {
            Direction.DOWN -> loc.copy(second = loc.second + 1)
            Direction.UP -> loc.copy(second = loc.second - 1)
            Direction.RIGHT -> loc.copy(first = loc.first + 1)
            Direction.LEFT -> loc.copy(first = loc.first - 1)
        }
        return nextLoc
    }

    fun part2(input: List<String>): Int {
        var output = 0
        val map = input.map { it.toCharArray().toTypedArray() }.toTypedArray()
        val start = Pair(map[0].indexOfFirst { it == '|' }, 0)
        var dir = Direction.DOWN
        var cur = start
        var curVal = map[cur.second][cur.first]
        while (curVal != ' ') {
            if (curVal == '+') {
                dir = when (dir) {
                    Direction.DOWN,
                    Direction.UP -> if (map[cur.second][cur.first - 1] == ' ') Direction.RIGHT else Direction.LEFT
                    Direction.RIGHT,
                    Direction.LEFT -> if (map[cur.second - 1][cur.first] == ' ') Direction.DOWN else Direction.UP
                }
            }
            output++
            cur = next(cur, dir)
            curVal = map[cur.second][cur.first]
        }
        return output
    }

}