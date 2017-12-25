import org.junit.Assert.assertEquals
import org.junit.Test
import java.io.File

class Day25Test {

    private val input = File("inputs/25/input.txt").readLines()

    @Test
    fun part1() {
        assertEquals(2794, Day25.part1(input))
    }
}