import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Test
import java.io.File

class Day09Test {

    private val input = File("inputs/09/input.txt").readText()


    @Test
    fun cancellationTest() {
        val root = Day09.Element.Root()
        assertEquals(root, Day09.Element.Cancellation(root).accept('!'))
    }

    @Test
    fun garbageTest() {
        val root = Day09.Element.Root()
        val garbage = Day09.Element.Garbage(root)
        assertEquals(garbage, garbage.accept('a'))
        assert(garbage.accept('!') is Day09.Element.Cancellation)
        assertEquals(root, garbage.accept('>'))
        arrayListOf("<>", "<random characters>", "<<<<>", "<{!>}>", "<!!>", "<!!!>>", """<{o"i!a,<{i<a>""")
                .onEach {
                    assert(it.asIterable().fold(garbage as Day09.Element, { element, char -> element.accept(char) }) is Day09.Element.Root)
                }
    }

    @Test
    fun ASTTest() {
        val root = Day09.createAST("{}") as? Day09.Element.Root
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
        ).map { Day09.createAST(it).groups() })
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
        ).map { Day09.part1(it) })
        assertEquals(9662, Day09.part1(input))
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
        ).map { Day09.part2(it) })
        assertEquals(4903, Day09.part2(input))
    }
}