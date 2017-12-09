import org.junit.Test

import org.junit.Assert.*
import java.io.File

class Day8Test {

    private val input = File("8/input.txt").readLines()
    private val day8 = Day8()

    @Test
    fun part1() {
        assertEquals(1, day8.part1(listOf(
                "b inc 5 if a > 1",
                "a inc 1 if b < 5",
                "c dec -10 if a >= 1",
                "c inc -20 if c == 10")))
        assertEquals(3880, day8.part1(input))
    }

    @Test
    fun part2() {
        assertEquals(10, day8.part2(listOf(
                "b inc 5 if a > 1",
                "a inc 1 if b < 5",
                "c dec -10 if a >= 1",
                "c inc -20 if c == 10")))
        assertEquals(5035, day8.part2(input))
    }
}