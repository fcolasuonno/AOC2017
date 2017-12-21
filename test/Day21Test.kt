import org.junit.Assert.assertEquals
import org.junit.Test
import java.io.File

class Day21Test {

    private val input = File("inputs/21/input.txt").readLines()

    @Test
    fun part1() {
        val testinput = arrayListOf(
                "../.# => ##./#../...",
                ".#./..#/### => #..#/..../..../#..#")
        assertEquals(12, Day21.part1(testinput, 2))
        assertEquals(150, Day21.part1(input, 5))
    }

    @Test
    fun part2() {
        assertEquals(2606275, Day21.part1(input, 18))
    }
}