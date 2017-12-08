import org.junit.Before
import org.junit.Test

import org.junit.Assert.*
import java.io.File

class Day5Test {


    private val input = File("5/input.txt").readLines()
    private val day5 = Day5()

    @Test
    fun part1() {
        assertEquals(5, day5.part1(listOf("0","3","0","1","-3")))
        assertEquals(351282, day5.part1(input))
    }

    @Test
    fun part2() {
        assertEquals(10, day5.part2(listOf("0","3","0","1","-3")))
        assertEquals(24568703, day5.part2(input))
    }
}