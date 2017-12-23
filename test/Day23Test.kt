import org.junit.Assert.assertEquals
import org.junit.Test
import java.io.File

class Day23Test {

    private val input = File("inputs/23/input.txt").readLines()

    @Test
    fun part1() {
        assertEquals(5929, Day23.part1(input))
    }

    @Test
    fun testEquivalence() {
        val regB = 79
        val regC = 85
        assertEquals(Day23.asmEquivalent(regB, regC), Day23.asmInterpreted(input, regB, regC))
    }

    @Test
    fun part2() {
        val regB = 107900
        val regC = 17000
        assertEquals(907, Day23.asmEquivalent(regB, regC))
    }

}