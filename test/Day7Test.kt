import org.junit.Assert.assertEquals
import org.junit.Test
import java.io.File

class Day7Test {


    private val input = File("7/input.txt").readLines()
    private val day7 = Day7()

    @Test
    fun part1() {
        val testInput = "fwft (72) -> ktlj, cntj, xhth\n" +
                "pbga (66)\n" +
                "xhth (57)\n" +
                "ebii (61)\n" +
                "havc (66)\n" +
                "ktlj (57)\n" +
                "qoyq (66)\n" +
                "padx (45) -> pbga, havc, qoyq\n" +
                "tknk (41) -> ugml, padx, fwft\n" +
                "jptl (61)\n" +
                "ugml (68) -> gyxo, ebii, jptl\n" +
                "gyxo (61)\n" +
                "cntj (57)"
        assertEquals("tknk", day7.part1(testInput.split("\n")))
        assertEquals("veboyvy", day7.part1(input))
    }

    @Test
    fun part2() {
        val testInput = "fwft (72) -> ktlj, cntj, xhth\n" +
                "pbga (66)\n" +
                "xhth (57)\n" +
                "ebii (61)\n" +
                "havc (66)\n" +
                "ktlj (57)\n" +
                "qoyq (66)\n" +
                "padx (45) -> pbga, havc, qoyq\n" +
                "tknk (41) -> ugml, padx, fwft\n" +
                "jptl (61)\n" +
                "ugml (68) -> gyxo, ebii, jptl\n" +
                "gyxo (61)\n" +
                "cntj (57)"
        assertEquals(60, day7.part2(testInput.split("\n")))
        assertEquals(749, day7.part2(input))
    }
}