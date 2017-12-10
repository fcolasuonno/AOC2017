import org.junit.Assert.assertEquals
import org.junit.Test
import java.io.File

class Day2Test {


    private val input = File("2/input.txt").readLines()
    private val day2 = Day2()

    @Test
    fun part1() {
        assertEquals(18, day2.part1(listOf(
                "5 1 9 5",
                "7 5 3",
                "2 4 6 8")))
        assertEquals(37923, day2.part1(input))

    }

    @Test
    fun part2() {
        assertEquals(9, day2.part2(listOf(
                "5 9 2 8",
                "9 4 7 3",
                "3 8 6 5")))
        assertEquals(263, day2.part2(input))

    }
}