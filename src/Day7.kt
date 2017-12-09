class Day7 {

    data class Tower(val name: String, val weight: Int, val children: List<String>)

    fun part1(input: List<String>) = towerMap(input).let {
        it.keys.subtract(it.values.flatMap { it.children })
    }.single()


    fun part2(input: List<String>) = towerMap(input).let { towerMap ->
        towerMap.values.filter { it.children.isNotEmpty() }
                .map { toWeight(it, towerMap) }
                .filter { group -> isUnbalanced(group) }
                .minBy { it.keys.sum() }
                ?.let {
                    val (unbalanced, balanced) = it.entries.partition { it.value.size == 1 }
                    towerMap[unbalanced.single().value.single()]?.let { it.weight - unbalanced.single().key + balanced.single().key }
                }
    }

    private fun toWeight(it: Tower, towerMap: Map<String, Tower>) =
            it.children.groupBy { weight(towerMap, it) }

    private fun isUnbalanced(group: Map<Int, List<String>>) = group.size == 2

    private fun weight(towerMap: Map<String, Tower>, child: String): Int {
        return towerMap[child]?.let {
            it.weight + it.children.sumBy { weight(towerMap, it) }
        } ?: 0
    }

    private fun towerMap(input: List<String>): Map<String, Tower> {
        return input.map {
            """([a-z]+) \(([0-9]+)\)( -> ([a-z, ]+))?""".toRegex().matchEntire(it)?.let {
                val (name, weight, _, children) = it.destructured
                Tower(name, weight.toInt(), if (children.isEmpty()) emptyList() else children.split("[^a-z]+".toRegex()))
            }
        }.filterNotNull().associateBy { it.name }
    }
}
