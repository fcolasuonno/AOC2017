import org.junit.Assert.assertEquals
import org.junit.Test
import java.io.File

class Day08Test {

    private val input = File("inputs/08/input.txt").readLines()


    @Test
    fun part1() {
        assertEquals(1, Day08.part1(listOf(
                "b inc 5 if a > 1",
                "a inc 1 if b < 5",
                "c dec -10 if a >= 1",
                "c inc -20 if c == 10")))
        assertEquals(3880, Day08.part1(input))
    }

    @Test
    fun part2() {
        assertEquals(10, Day08.part2(listOf(
                "b inc 5 if a > 1",
                "a inc 1 if b < 5",
                "c dec -10 if a >= 1",
                "c inc -20 if c == 10")))
        assertEquals(5035, Day08.part2(input))
    }
}