import org.junit.Assert.assertEquals
import org.junit.Test
import java.io.File

class Day04Test {


    private val input = File("inputs/04/input.txt").readLines()


    @Test
    fun part1() {
        assertEquals(1, Day04.part1(listOf("aa bb cc dd ee")))
        assertEquals(0, Day04.part1(listOf("aa bb cc dd aa")))
        assertEquals(1, Day04.part1(listOf("aa bb cc dd aaa")))

        assertEquals(325, Day04.part1(input))
    }

    @Test
    fun part2() {
        assertEquals(1, Day04.part2(listOf("abcde fghij")))
        assertEquals(0, Day04.part2(listOf("abcde xyz ecdab")))
        assertEquals(1, Day04.part2(listOf("a ab abc abd abf abj")))
        assertEquals(1, Day04.part2(listOf("iiii oiii ooii oooi oooo")))
        assertEquals(0, Day04.part2(listOf("oiii ioii iioi iiio")))

        assertEquals(119, Day04.part2(input))

    }
}