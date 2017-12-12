import org.junit.Assert.assertEquals
import org.junit.Test
import java.io.File

class Day12Test {

    private val input = File("inputs/12/input.txt").readLines()


    @Test
    fun part1() {
        val testInput = listOf("0 <-> 2",
                "1 <-> 1",
                "2 <-> 0, 3, 4",
                "3 <-> 2, 4",
                "4 <-> 2, 3, 6",
                "5 <-> 6",
                "6 <-> 4, 5")
        assertEquals(6, Day12.part1(testInput))
        assertEquals(378, Day12.part1(input))

    }

    @Test
    fun part2() {
        assertEquals(2, Day12.part2(listOf("0 <-> 2",
                "1 <-> 1",
                "2 <-> 0, 3, 4",
                "3 <-> 2, 4",
                "4 <-> 2, 3, 6",
                "5 <-> 6",
                "6 <-> 4, 5")))

        assertEquals(2, Day12.part2(listOf("3 <-> 2, 4",
                "0 <-> 2",
                "1 <-> 1",
                "2 <-> 0, 3, 4",
                "4 <-> 2, 3, 6",
                "5 <-> 6",
                "6 <-> 4, 5")))

        assertEquals(204, Day12.part2(input))
    }
}