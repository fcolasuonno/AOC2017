import org.junit.Assert.assertEquals
import org.junit.Test
import java.io.File

class Day06Test {


    private val input = File("inputs/06/input.txt").readText()


    @Test
    fun part1() {
        assertEquals(5, Day06.part1("0   2   7   0"))
        assertEquals(6681, Day06.part1(input))
    }

    @Test
    fun part2() {
        assertEquals(4, Day06.part2("0   2   7   0"))
        assertEquals(2392, Day06.part2(input))
    }
}