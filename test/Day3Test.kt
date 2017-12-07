import org.junit.Before
import org.junit.Test

import org.junit.Assert.*
import java.io.File

class Day3Test {


    private val input = 368078
    private val day3 = Day3()

    @Test
    fun part1() {
        assertEquals(1, day3.part1(8))
        assertEquals(2, day3.part1(9))
        assertEquals(3, day3.part1(12))
        assertEquals(4, day3.part1(17))
        assertEquals(2, day3.part1(19))
        assertEquals(4, day3.part1(21))
        assertEquals(2, day3.part1(23))
        assertEquals(31, day3.part1(1024))

        assertEquals(371, day3.part1(input))

    }

    @Test
    fun part2() {
        assertEquals(59, day3.part2(58))
        assertEquals(806, day3.part2(747))

        assertEquals(369601, day3.part2(input))

    }

    @Test
    fun incrementCoord() {
        assertEquals(Pair(1,0), Pair(0,0).inc())
        assertEquals(Pair(1,1), Pair(1,0).inc())
        assertEquals(Pair(0,1), Pair(1,1).inc())
        assertEquals(Pair(-1,1), Pair(0,1).inc())
        assertEquals(Pair(-1,0), Pair(-1,1).inc())
        assertEquals(Pair(-1,-1), Pair(-1,0).inc())
        assertEquals(Pair(0,-1), Pair(-1,-1).inc())
        assertEquals(Pair(1,-1), Pair(0,-1).inc())
        assertEquals(Pair(2,-1), Pair(1,-1).inc())

        assertEquals(Pair(1,2), Pair(2,2).inc())
        assertEquals(Pair(-2,1), Pair(-2,2).inc())
        assertEquals(Pair(-1,-2), Pair(-2,-2).inc())
        assertEquals(Pair(3,-2), Pair(2,-2).inc())

    }
}