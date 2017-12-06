class Day1 {

    fun part1(input: String) = input
            .let { it + it.first() }
            .zipWithNext()
            .filter { it.first == it.second }
            .sumBy { Character.getNumericValue(it.first) }

    fun part2(input: String) = input
            .mapIndexed { index, c -> Pair(c, input.boundedGet(index + input.length / 2)) }
            .filter { it.first == it.second }
            .sumBy { Character.getNumericValue(it.first) }


    private fun String.boundedGet(index: Int) = this[index % length]
}