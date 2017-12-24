import org.junit.Assert.assertEquals
import org.junit.Test
import java.io.File

class Day24Test {

    private val input = File("inputs/24/input.txt").readLines()

    @Test
    fun part1() {
        val testInput = arrayListOf("0/2",
                "2/2",
                "2/3",
                "3/4",
                "3/5",
                "0/1",
                "10/1",
                "9/10")
        assertEquals(31, Day24.part1(testInput))
        assertEquals(1859, Day24.part1(input))
    }

    @Test
    fun part2() {
        assertEquals(1799, Day24.part2(input))
    }

}