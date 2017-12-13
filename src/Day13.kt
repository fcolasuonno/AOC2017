object Day13 {

    fun part1(input: List<String>) = input.map {
        val (level, range) = """([0-9]+)[^0-9]+([0-9]+)""".toRegex().matchEntire(it)!!.destructured
        Pair(level.toInt(), range.toInt())
    }.filter {
        val scannerPeriodicity = it.second * 2 - 2
        val packetIsScanner = it.first % scannerPeriodicity == 0
        packetIsScanner
    }.sumBy { it.first * it.second }

    fun part2(input: List<String>) = input.map {
        val (level, range) = """([0-9]+)[^0-9]+([0-9]+)""".toRegex().matchEntire(it)!!.destructured
        Pair(level.toInt(), range.toInt())
    }.map {
        val rangePeriodicity = it.second * 2 - 2
        Pair(it.first, rangePeriodicity)
    }.let {
        var wait = 0
        while (it.any { scanner -> (wait + scanner.first) % scanner.second == 0 }) {
            wait++
        }
        wait
    }
}