object Day24 {

    data class Component(val start: Int, val end: Int) {
        val value = start + end

        override fun toString(): String {
            return "$start,$end"
        }
    }

    fun part1(input: List<String>): Int {
        val components = input.map { it.split('/').map { it.toInt() } }.map { Component(it[0], it[1]) }
        return components.filter { it.start == 0 || it.end == 0 }.map {
            combinations(if (it.start != 0) it.start else it.end, components.minus(it), listOf(it)).map { it.sumBy { it.value } }.max() ?: 0
        }.max() ?: 0
    }

    private fun combinations(previous: Int, usableComponents: List<Component>, initialBridge: List<Component>): List<List<Component>> {
        return mutableListOf(initialBridge) + usableComponents.filter { it.start == previous || it.end == previous }.flatMap { component ->
            val continuation = if (component.start == previous) component.end else component.start
            combinations(continuation, usableComponents.minus(component), initialBridge + component)
        }
    }

    fun part2(input: List<String>): Int {
        val components = input.map { it.split('/').map { it.toInt() } }.map { Component(it[0], it[1]) }
        val longestBridges = components.filter { it.start == 0 || it.end == 0 }.flatMap {
            combinations(if (it.start != 0) it.start else it.end, components.minus(it), listOf(it))
        }.groupBy { it.size }.maxBy { it.key }?.value
        return longestBridges.orEmpty().map { it.sumBy { it.value } }.max() ?: 0
    }
}
