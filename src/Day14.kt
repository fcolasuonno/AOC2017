object Day14 {

    fun knot(input: String, size: Int = 256): String {
        val knot = Array(size, { index -> index })
        var position = 0
        var skip = 0

        for (round in 1..64) {
            val inputList = input.map { it.toInt() } + arrayOf(17, 31, 73, 47, 23)

            inputList.forEach { sliceSize ->
                val endPosition = position + sliceSize
                val endIndices = position until Math.min(size, endPosition)
                val startIndices = 0 until Math.max(0, endPosition - size)
                val modifiedPositions = endIndices + startIndices
                val reversedArray = knot.sliceArray(modifiedPositions).reversedArray()
                modifiedPositions.forEachIndexed { index, knotIndex ->
                    knot[knotIndex] = reversedArray[index]
                }
                position = (endPosition + skip++) % size

            }
        }
        return knot.toList().windowed(size = 16, step = 16).map { it.reduce { acc, i -> acc.xor(i) } }
                .joinToString(separator = "") { String.format("%02x", it) }
    }


    fun part1(input: String): Int {
        var c = 0
        for (row in 0 until 128) {
            c += knot(input + "-" + row).toCharArray().map { toBinary(it) }.sumBy { it.count { square -> square == 1 } }
        }
        return c
    }

    private fun toBinary(it: Char): IntArray {
        val int = if (it.isDigit()) it - '0' else 10 + (it.toLowerCase() - 'a')
        val output = IntArray(4)
        output[3] = (int.and(0x1))
        output[2] = (int.shr(1).and(0x1))
        output[1] = (int.shr(2).and(0x1))
        output[0] = (int.shr(3).and(0x1))
        return output
    }

    fun part2(input: String): Int {
        val grid = mutableListOf<MutableList<Int>>()
        for (row in 0 until 128) {
            grid.add(row, knot(input + "-" + row).toCharArray().map { toBinary(it).toList() }.flatten().toMutableList())
        }
        var groupNumber = 0
        for (col in 0 until 128) {
            for (row in 0 until 128) {
                if (grid[row][col] == 1) {
                    groupNumber++
                    clear(grid, row, col)
                }
            }
        }
        return groupNumber
    }

    private fun clear(grid: MutableList<MutableList<Int>>, row: Int, col: Int) {
        if (grid[row][col] == 0)
            return
        grid[row][col] = 0
        if (row > 1) {
            if (col > 1) {
                clear(grid, row - 1, col - 1)
            }
            if (col < 127) {
                clear(grid, row - 1, col + 1)
            }
        }
        if (row < 127) {
            if (col > 1) {
                clear(grid, row + 1, col - 1)
            }
            if (col < 127) {
                clear(grid, row + 1, col + 1)
            }
        }
    }
}