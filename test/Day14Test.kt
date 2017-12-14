import org.junit.Assert.assertEquals
import org.junit.Test

class Day14Test {

    @Test
    fun part1() {
        assertEquals(8140, Day14.part1("jxqlasbh"))
    }

    @Test
    fun part2() {
        assertEquals(1242, Day14.part2("flqrgnkx"))
        assertEquals(1182, Day14.part2("jxqlasbh"))
    }
}