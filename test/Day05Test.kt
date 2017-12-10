import org.junit.Assert.assertEquals
import org.junit.Test
import java.io.File

class Day05Test {


    private val input = File("inputs/05/input.txt").readLines()


    @Test
    fun part1() {
        assertEquals(5, Day05.part1(listOf("0", "3", "0", "1", "-3")))
        assertEquals(351282, Day05.part1(input))
    }

    @Test
    fun part2() {
        assertEquals(10, Day05.part2(listOf("0", "3", "0", "1", "-3")))
        assertEquals(24568703, Day05.part2(input))
    }
}