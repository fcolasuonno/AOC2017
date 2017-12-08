class Day5 {

    fun part1(input: List<String>) = input.map { string -> string.toInt() }.toIntArray().let {
        var count = 0
        var index = 0
        while (index < it.size) {
            val newIndex = it[index]
            it[index]++
            index += newIndex
            count++
        }
        count
    }


    fun part2(input: List<String>) = input.map { string -> string.toInt() }.toIntArray().let {
        var count = 0
        var index = 0
        while (index < it.size) {
            val newIndex = it[index]
            if (newIndex >= 3) {
                it[index]--
            } else {
                it[index]++
            }
            index += newIndex
            count++
        }
        count
    }

}