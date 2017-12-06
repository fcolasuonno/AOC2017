import org.junit.Assert.assertEquals
import org.junit.Test
import java.io.File

class Day1Test {

    private val input = File("1/input.txt").readText().trim()
    private val day1 = Day1()

    @Test
    fun part1() {
        assertEquals(1228, day1.part1(input))

    }

    @Test
    fun part2() {
        assertEquals(1238, day1.part2(input))
    }
}