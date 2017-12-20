import org.junit.Assert.assertEquals
import org.junit.Test
import java.io.File

class Day20Test {

    private val input = File("inputs/20/input.txt").readLines()

    @Test
    fun part1() {
        assertEquals(125, Day20.part1(input))
    }

    @Test
    fun part2() {
        assertEquals(1, Day20.part2(arrayListOf("p=<-6,0,0>, v=< 3,0,0>, a=< 0,0,0>",
                "p=<-4,0,0>, v=< 2,0,0>, a=< 0,0,0>",
                "p=<-2,0,0>, v=< 1,0,0>, a=< 0,0,0>",
                "p=< 3,0,0>, v=<-1,0,0>, a=< 0,0,0>")))
        assertEquals(7493, Day20.part2(input))
    }
}