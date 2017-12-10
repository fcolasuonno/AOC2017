import org.junit.Assert.assertEquals
import org.junit.Test
import java.io.File

class Day10Test {

    private val input = File("10/input.txt").readText().trim()
    private val day10 = Day10()

    @Test
    fun part1() {
        assertEquals(12, day10.part1(5, "3, 4, 1, 5"))
        assertEquals(46600, day10.part1(256, input))

    }

    @Test
    fun part2() {
        assertEquals(64, arrayOf(65, 27, 9, 1, 4, 3, 40, 50, 91, 7, 6, 0, 2, 5, 68, 22).reduce { acc, i -> acc.xor(i) })
        assertEquals("a2582a3a0e66e6e86e3812dcb672a272", day10.part2(256, ""))
        assertEquals("33efeb34ea91902bb2f59c9920caa6cd", day10.part2(256, "AoC 2017"))
        assertEquals("3efbe78a8d82f29979031a4aa0b16a9d", day10.part2(256, "1,2,3"))
        assertEquals("63960835bcdc130f0b66d7ff4f6a5a8e", day10.part2(256, "1,2,4"))
        assertEquals("23234babdc6afa036749cfa9b597de1b", day10.part2(256, input))
    }
}