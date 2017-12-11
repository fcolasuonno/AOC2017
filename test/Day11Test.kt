import org.junit.Assert.assertEquals
import org.junit.Test
import java.io.File

class Day11Test {

    private val input = File("inputs/11/input.txt").readText().trim()


    @Test
    fun part1() {
        assertEquals(3, Day11.part1("ne,ne,ne"))
        assertEquals(0, Day11.part1("ne,ne,sw,sw"))
        assertEquals(2, Day11.part1("ne,ne,s,s"))
        assertEquals(3, Day11.part1("se,sw,se,sw,sw"))
        assertEquals(696, Day11.part1(input))
    }

    @Test
    fun part2() {
        assertEquals(1461, Day11.part2(input))
    }
}