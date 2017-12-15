object Day15 {

    fun part1(genA: Long, genB: Long): Int =
            generateSequence(genA, { it * 16807 % 2147483647 })
                    .zip(
                            generateSequence(genB, { it * 48271 % 2147483647 })
                    ).drop(1).take(40_000_000)
                    .count { it.first.and(0xffff) == it.second.and(0xffff) }


    fun part2(genA: Long, genB: Long): Int =
            generateSequence(genA) { it * 16807 % 2147483647 }.filter { it % 4L == 0L }
                    .zip(
                            generateSequence(genB) { it * 48271 % 2147483647 }.filter { it % 8L == 0L }
                    ).drop(1).take(5_000_000)
                    .count { it.first.and(0xffff) == it.second.and(0xffff) }
}

