import org.junit.Assert.assertEquals
import org.junit.Test
import java.io.File

class Day13Test {

    private val input = File("inputs/13/input.txt").readLines()

    @Test
    fun part1() {
        val testInput = listOf(
                "0: 3",
                "1: 2",
                "4: 4",
                "6: 4")
        assertEquals(24, Day13.part1(testInput))
        assertEquals(1504, Day13.part1(input))
    }

    @Test
    fun part2() {
        val testInput = listOf(
                "0: 3",
                "1: 2",
                "4: 4",
                "6: 4")
        assertEquals(10, Day13.part2(testInput))
        assertEquals(3823370, Day13.part2(input))
    }
}