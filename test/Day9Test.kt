import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Test
import java.io.File

class Day9Test {

    private val input = File("9/input.txt").readText()
    private val day9 = Day9()

    @Test
    fun cancellationTest() {
        val root = Day9.Element.Root()
        assertEquals(root, Day9.Element.Cancellation(root).accept('!'))
    }

    @Test
    fun garbageTest() {
        val root = Day9.Element.Root()
        val garbage = Day9.Element.Garbage(root)
        assertEquals(garbage, garbage.accept('a'))
        assert(garbage.accept('!') is Day9.Element.Cancellation)
        assertEquals(root, garbage.accept('>'))
        arrayListOf("<>", "<random characters>", "<<<<>", "<{!>}>", "<!!>", "<!!!>>", """<{o"i!a,<{i<a>""")
                .onEach {
                    assert(it.asIterable().fold(garbage as Day9.Element, { element, char -> element.accept(char) }) is Day9.Element.Root)
                }
    }

    @Test
    fun ASTTest() {
        val root = day9.createAST("{}") as? Day9.Element.Root
        assertNotNull(root)
        assertEquals(1, root?.group?.level)
        assertEquals(1, root?.groups())
        assertEquals(listOf(
                3,
                3,
                6,
                1,
                1,
                5,
                2
        ), arrayListOf(
                "{{{}}}",
                "{{},{}}",
                "{{{},{},{{}}}}",
                "{<{},{},{{}}>}",
                "{<a>,<a>,<a>,<a>}",
                "{{<a>},{<a>},{<a>},{<a>}}",
                "{{<!>},{<!>},{<!>},{<a>}}"
        ).map { day9.createAST(it).groups() })
    }

    @Test
    fun part1() {
        assertEquals(listOf(
                1,
                6,
                5,
                16,
                1,
                9,
                9,
                3
        ), arrayListOf(
                "{}",
                "{{{}}}",
                "{{},{}}",
                "{{{},{},{{}}}}",
                "{<a>,<a>,<a>,<a>}",
                "{{<ab>},{<ab>},{<ab>},{<ab>}}",
                "{{<!!>},{<!!>},{<!!>},{<!!>}}",
                "{{<a!>},{<a!>},{<a!>},{<ab>}}"
        ).map { day9.part1(it) })
        assertEquals(9662, day9.part1(input))
    }

    @Test
    fun part2() {
        assertEquals(listOf(
                0,
                17,
                3,
                2,
                0,
                0,
                10
        ), arrayListOf(
                "{<>}",
                "{<random characters>}",
                "{{<<<<>}}",
                "{{},{<{!>}>}}",
                "{<!!>}",
                "{<!!!>>}",
                """{<{o"i!a,<{i<a>,{}}"""
        ).map { day9.part2(it) })
        assertEquals(4903, day9.part2(input))
    }
}