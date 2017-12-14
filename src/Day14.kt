object Day14 {

    fun knot(input: String): String = Day10.part2(input)

    private fun toBinary(it: Char): IntArray {
        val int = if (it.isDigit()) it - '0' else 10 + (it.toLowerCase() - 'a')
        val output = IntArray(4)
        output[3] = -(int.and(0x1))
        output[2] = -(int.shr(1).and(0x1))
        output[1] = -(int.shr(2).and(0x1))
        output[0] = -(int.shr(3).and(0x1))
        return output
    }

    fun part1(input: String): Int = (0 until 128)
            .sumBy {
                knot(input + "-" + it)
                        .toCharArray()
                        .map { toBinary(it) }
                        .sumBy { it.count { square -> square == -1 } }
            }

    fun part2(input: String): Int {
        val grid = mutableListOf<MutableList<Int>>()
        for (row in 0 until 128) {
            grid.add(row, knot(input + "-" + row).toCharArray().map { toBinary(it).toList() }.flatten().toMutableList())
        }
        var groupNumber = 0
        for (row in 0 until 128) {
            for (col in 0 until 128) {
                if (grid[row][col] == -1) {
                    groupNumber++
                    clear(grid, row, col, groupNumber)
                }
            }
        }
        return groupNumber
    }

    private fun clear(grid: MutableList<MutableList<Int>>, row: Int, col: Int, groupNumber: Int) {
        if (grid[row][col] != -1)
            return
        grid[row][col] = groupNumber
        if (col < 127) {
            clear(grid, row, col + 1, groupNumber)
        }
        if (col > 0) {
            clear(grid, row, col - 1, groupNumber)
        }
        if (row < 127) {
            clear(grid, row + 1, col, groupNumber)
        }
        if (row > 0) {
            clear(grid, row - 1, col, groupNumber)
        }
    }
}