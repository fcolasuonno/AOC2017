import org.junit.Before
import org.junit.Test

import org.junit.Assert.*
import java.io.File

class Day4Test {


    private val input = File("4/input.txt").readLines()
    private val day4 = Day4()

    @Test
    fun part1() {
        assertEquals(1, day4.part1(listOf("aa bb cc dd ee")))
        assertEquals(0, day4.part1(listOf("aa bb cc dd aa")))
        assertEquals(1, day4.part1(listOf("aa bb cc dd aaa")))

        assertEquals(325, day4.part1(input))
    }

    @Test
    fun part2() {
        assertEquals(1, day4.part2(listOf("abcde fghij")))
        assertEquals(0, day4.part2(listOf("abcde xyz ecdab")))
        assertEquals(1, day4.part2(listOf("a ab abc abd abf abj")))
        assertEquals(1, day4.part2(listOf("iiii oiii ooii oooi oooo")))
        assertEquals(0, day4.part2(listOf("oiii ioii iioi iiio")))

        assertEquals(119, day4.part2(input))

    }
}