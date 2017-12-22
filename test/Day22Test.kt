import org.junit.Assert.assertEquals
import org.junit.Test
import java.io.File

class Day22Test {

    private val input = File("inputs/22/input.txt").readLines()

    @Test
    fun part1() {
        val testinput = arrayListOf(
                "..#",
                "#..",
                "...")
        assertEquals(5587, Day22.part1(testinput))
        assertEquals(5462, Day22.part1(input))
    }

    @Test
    fun part2() {
        val testinput = arrayListOf(
                "..#",
                "#..",
                "...")
        assertEquals(2511944, Day22.part2(testinput))
        assertEquals(2512135, Day22.part2(input))
    }
}