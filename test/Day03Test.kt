import org.junit.Assert.assertEquals
import org.junit.Test

class Day03Test {


    private val input = 368078


    @Test
    fun part1() {
        assertEquals(1, Day03.part1(8))
        assertEquals(2, Day03.part1(9))
        assertEquals(3, Day03.part1(12))
        assertEquals(4, Day03.part1(17))
        assertEquals(2, Day03.part1(19))
        assertEquals(4, Day03.part1(21))
        assertEquals(2, Day03.part1(23))
        assertEquals(31, Day03.part1(1024))

        assertEquals(371, Day03.part1(input))

    }

    @Test
    fun part2() {
        assertEquals(59, Day03.part2(58))
        assertEquals(806, Day03.part2(747))

        assertEquals(369601, Day03.part2(input))

    }
}