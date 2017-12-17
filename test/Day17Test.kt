import org.junit.Assert.assertEquals
import org.junit.Test

class Day17Test {

    @Test
    fun part1() {
        assertEquals(638, Day17.part1(3))
        assertEquals(996, Day17.part1(344))
    }

    @Test
    fun part2() {
        assertEquals(1898341, Day17.part2(344))
    }
}