object Day02 {

    fun part1(input: List<String>) = input.sumBy {
        it.split("\t", " ")
                .map { it.toInt() }
                .let { nums -> (nums.max() ?: 0) - (nums.min() ?: 0) }
    }

    fun part2(input: List<String>) = input.sumBy { row ->
        row.split("\t", " ")
                .map { it.toInt() }
                .let { `evenly divisible value`(it) }
    }

    private fun `evenly divisible value`(row: List<Int>): Int {
        for ((index1, num1) in row.withIndex()) {
            for ((index2, num2) in row.withIndex()) {
                if (index1 != index2) {
                    if (num1 % num2 == 0) {
                        return num1 / num2
                    }
                }
            }
        }
        throw Exception("Not found")
    }
}

