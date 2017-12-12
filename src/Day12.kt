object Day12 {

    fun part1(input: List<String>) = input
            .map { """([0-9]+)[^0-9]+([0-9, ]+)""".toRegex().matchEntire(it)!!.destructured }
            .associate { (id, connectionList) -> Pair(id, connectionList.split("[^0-9]+".toRegex()).toSet()) }
            .let { connections ->
                val connectionsToCheck = mutableSetOf("0")
                val seen = mutableSetOf<String>()
                while (connectionsToCheck.isNotEmpty()) {
                    val connection = connectionsToCheck.first()
                    seen.add(connection)
                    connectionsToCheck.addAll(connections[connection].orEmpty())
                    connectionsToCheck.removeAll(seen)
                }
                seen.size
            }

    fun part2(input: List<String>) = input
            .map { """([0-9]+)[^0-9]+([0-9, ]+)""".toRegex().matchEntire(it)!!.destructured }
            .associate { (id, connectionList) -> Pair(id, connectionList.split("[^0-9]+".toRegex()).toMutableSet()) }
            .let { connections ->
                val keys = connections.keys.toMutableSet()
                val foundGroups = mutableSetOf<String>()
                while (keys.isNotEmpty()) {
                    val start = keys.first()
                    val connectionsToCheck = mutableSetOf(start)
                    val seen = mutableSetOf<String>()
                    while (connectionsToCheck.isNotEmpty()) {
                        val connection = connectionsToCheck.first()
                        seen.add(connection)
                        connectionsToCheck.addAll(connections[connection].orEmpty())
                        connectionsToCheck.removeAll(seen)
                    }
                    keys.removeAll(seen)
                    foundGroups.removeAll(seen)
                    foundGroups.add(start)
                }
                foundGroups.size
            }

}