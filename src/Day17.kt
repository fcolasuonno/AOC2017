object Day17 {


    fun part1(input: Int): Int {
        var buffer = intArrayOf(0)
        var curr = 0
        for (i in 1..2017) {
            curr = (curr + input) % buffer.size + 1
            buffer = buffer.sliceArray(0 until curr) + i + buffer.sliceArray(curr until buffer.size)
        }
        return buffer[(curr + 1) % buffer.size]
    }

    fun part2(input: Int): Int {
        var bufferSize = 1
        var curr = 0
        var output = 0
        for (i in 1..50000000) {
            curr = (curr + input) % bufferSize + 1
            bufferSize++
            if (curr == 1) output = i
        }
        return output
    }
}