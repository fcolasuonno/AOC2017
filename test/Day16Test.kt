import org.junit.Assert.assertEquals
import org.junit.Test
import java.io.File

class Day16Test {

    private val input = File("inputs/15/input.txt").readText().split(',')

    @Test
    fun part1() {
        assertEquals("baedc", Day16.part1(arrayListOf(
                "s1",
                "x3/4",
                "pe/b"
        ), 5))
        assertEquals("lgpkniodmjacfbeh", Day16.part1(input))
    }

    @Test
    fun part2() {
        assertEquals(Day16.part2(input, iterations = 100), Day16.part2slow(input, iterations = 100))
        assertEquals(Day16.part2Faster(input, iterations = 100), Day16.part2(input, iterations = 100))
        assertEquals(Day16.part2Smarter(input, iterations = 100), Day16.part2Faster(input, iterations = 100))
        //Takes about 2 minutes
//        assertEquals("hklecbpnjigoafmd", Day16.part2(input, iterations = 1_000_000_000))
        //Takes about 11 seconds
//        assertEquals("hklecbpnjigoafmd", Day16.part2Faster(input, iterations = 1_000_000_000))
        //Takes about 950 milliseconds
        assertEquals("hklecbpnjigoafmd", Day16.part2Smarter(input, iterations = 1_000_000_000))
    }
}