import org.junit.Assert.assertEquals
import org.junit.Test
import java.io.File

class Day18Test {

    private val input = File("inputs/18/input.txt").readLines()

    @Test
    fun part1() {
        var testInput = listOf("set a 1",
                "add a 2",
                "mul a a",
                "mod a 5",
                "snd a",
                "set a 0",
                "rcv a",
                "jgz a -1",
                "set a 1",
                "jgz a -2")
        assertEquals(4, Day18.part1(testInput))
        assertEquals(3423, Day18.part1(input))
    }

    @Test
    fun part2() {
        assertEquals(7493, Day18.part2(input))
    }
}