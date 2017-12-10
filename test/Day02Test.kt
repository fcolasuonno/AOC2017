import org.junit.Assert.assertEquals
import org.junit.Test
import java.io.File

class Day02Test {


    private val input = File("inputs/02/input.txt").readLines()


    @Test
    fun part1() {
        assertEquals(18, Day02.part1(listOf(
                "5 1 9 5",
                "7 5 3",
                "2 4 6 8")))
        assertEquals(37923, Day02.part1(input))

    }

    @Test
    fun part2() {
        assertEquals(9, Day02.part2(listOf(
                "5 9 2 8",
                "9 4 7 3",
                "3 8 6 5")))
        assertEquals(263, Day02.part2(input))

    }
}