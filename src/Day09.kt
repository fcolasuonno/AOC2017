object Day09 {

    interface Visitor {
        fun accept(c: Char): Element
    }

    sealed class Element(val children: MutableList<Element> = mutableListOf()) : Visitor {
        class Root : Element() {

            val group: Group = Group(this, 1)

            override fun accept(c: Char): Element {
                return group
            }

            fun groups(): Int {
                return groups(group)
            }

            private fun groups(group: Group): Int {
                return 1 + group.children.filterIsInstance<Group>().sumBy { groups(it) }
            }
        }

        data class Group(val parent: Element, val level: Int) : Element() {
            override fun accept(c: Char): Element {
                return when (c) {
                    '{' -> Group(this, level + 1).also { children.add(it) }
                    '}' -> parent
                    '<' -> Garbage(this).also { children.add(it) }
                    else -> this
                }
            }
        }

        data class Garbage(val parent: Element, var garbageCharacters: Int = 0) : Element() {
            override fun accept(c: Char): Element {
                return when (c) {
                    '!' -> Cancellation(this).also { children.add(it) }
                    '>' -> parent
                    else -> this.also { garbageCharacters++ }
                }
            }
        }

        data class Cancellation(val parent: Element) : Element() {
            override fun accept(c: Char): Element {
                return parent
            }
        }
    }

    fun createAST(input: String) = input.asSequence().fold(Element.Root() as Element, { a, b -> a.accept(b) }) as Element.Root


    private fun score(group: Element.Group): Int {
        return group.level + group.children.filterIsInstance<Element.Group>().sumBy { score(it) }
    }

    fun part1(input: String) = score(createAST(input).group)

    private fun garbageCount(group: Element.Group): Int {
        return group.children.filterIsInstance<Element.Garbage>().sumBy { it.garbageCharacters } + group.children.filterIsInstance<Element.Group>().sumBy { garbageCount(it) }
    }

    fun part2(input: String) = garbageCount(createAST(input).group)

}