class Day6 {

    fun part1(input: String) = input.split("\\s+".toRegex()).map { string -> string.toInt() }.toIntArray().let { banks ->
        var count = 0
        val seen = mutableSetOf<String>()
        while (!seen.contains(banks.contentToString())) {
            seen.add(banks.contentToString())
            val maxIndex = banks.withIndex().maxBy { it.value }
            maxIndex?.let {
                banks[it.index] = 0
                var nextBank = it.index + 1
                for (i in it.value downTo 1) {
                    banks[nextBank++ % banks.size]++
                }
            }
            count++
        }
        count
    }


    fun part2(input: String) = input.split("\\s+".toRegex()).map { string -> string.toInt() }.toIntArray().let { banks ->
        var count = 0
        val seen = mutableMapOf<String, Int>()
        while (!seen.contains(banks.contentToString())) {
            seen[banks.contentToString()] = count
            val maxIndex = banks.withIndex().maxBy { it.value }
            maxIndex?.let {
                banks[it.index] = 0
                var nextBank = it.index + 1
                for (i in it.value downTo 1) {
                    banks[nextBank++ % banks.size]++
                }
            }
            count++
        }
        count - seen.getOrDefault(banks.contentToString(), 0)
    }

}