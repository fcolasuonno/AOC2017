object Day10 {

    fun part1(input: String, size: Int = 256): Int {
        val knot = Array(size, { index -> index })
        var position = 0
        var skip = 0
        input.split("[^0-9]+".toRegex()).map { it.toInt() }.forEach { sliceSize ->

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
        return knot[0] * knot[1]
    }

    fun part2(input: String, size: Int = 256): String {
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
}