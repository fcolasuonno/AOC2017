import org.junit.Assert.assertEquals
import org.junit.Test

class Day15Test {

    @Test
    fun part1() {
        assertEquals(588, Day15.part1(65, 8921))
        assertEquals(600, Day15.part1(699, 124))
    }

    @Test
    fun part2() {
        assertEquals(309, Day15.part2(65, 8921))
        assertEquals(313, Day15.part2(699, 124))
    }
}