import org.junit.Assert.assertEquals
import org.junit.Test
import java.io.File

class Day19Test {

    private val input = File("inputs/19/input.txt").readLines()

    @Test
    fun part1() {
        val testInput = listOf(
                "     |          ",
                "     |  +--+    ",
                "     A  |  C    ",
                " F---|----E|--+ ",
                "     |  |  |  D ",
                "     +B-+  +--+ ",
                "")
        assertEquals("ABCDEF", Day19.part1(testInput))
        assertEquals("LIWQYKMRP", Day19.part1(input))
    }

    @Test
    fun part2() {
        val testInput = listOf(
                "     |          ",
                "     |  +--+    ",
                "     A  |  C    ",
                " F---|----E|--+ ",
                "     |  |  |  D ",
                "     +B-+  +--+ ",
                "")
        assertEquals(38, Day19.part2(testInput))
        assertEquals(16764, Day19.part2(input))
    }
}