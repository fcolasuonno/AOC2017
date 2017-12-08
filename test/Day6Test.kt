import org.junit.Assert.assertEquals
import org.junit.Test
import java.io.File

class Day6Test {


    private val input = File("6/input.txt").readText()
    private val day6 = Day6()

    @Test
    fun part1() {
        assertEquals(5, day6.part1("0   2   7   0"))
        assertEquals(6681, day6.part1(input))
    }

    @Test
    fun part2() {
        assertEquals(4, day6.part2("0   2   7   0"))
        assertEquals(2392, day6.part2(input))
    }
}