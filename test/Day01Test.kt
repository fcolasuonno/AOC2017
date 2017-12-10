import org.junit.Assert.assertEquals
import org.junit.Test
import java.io.File

class Day01Test {

    private val input = File("inputs/01/input.txt").readText().trim()


    @Test
    fun part1() {
        assertEquals(1228, Day01.part1(input))

    }

    @Test
    fun part2() {
        assertEquals(1238, Day01.part2(input))
    }
}