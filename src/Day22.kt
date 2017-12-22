object Day22 {
    data class Node(val x: Int, val y: Int)

    enum class Direction {
        UP, RIGHT, DOWN, LEFT;

        fun left() =
                when (this) {
                    UP -> LEFT
                    RIGHT -> UP
                    DOWN -> RIGHT
                    LEFT -> DOWN
                }


        fun right() =
                when (this) {
                    UP -> RIGHT
                    RIGHT -> DOWN
                    DOWN -> LEFT
                    LEFT -> UP
                }

    }

    data class Carrier(var x: Int, var y: Int, var dir: Direction, val infectionMap: MutableSet<Node>, var infections: Int = 0) {
        fun burst() {
            val currentNode = Node(x, y)
            val currentIsInfected = infectionMap.contains(currentNode)
            dir = if (currentIsInfected) dir.right() else dir.left()
            if (currentIsInfected) {
                infectionMap.remove(currentNode)
            } else {
                infections++
                infectionMap.add(currentNode)
            }
            when (dir) {
                Direction.UP -> y--
                Direction.DOWN -> y++
                Direction.LEFT -> x--
                Direction.RIGHT -> x++
            }
        }
    }


    fun part1(input: List<String>): Int {
        val infectionMap = mutableSetOf<Node>()
        input.forEachIndexed { indexY, s ->
            s.forEachIndexed { indexX, c ->
                if (c == '#') infectionMap.add(Node(indexX - (input.size - 1) / 2, indexY - (s.length - 1) / 2))
            }
        }
        val carrier = Carrier(0, 0, Direction.UP, infectionMap)
        for (iteration in 0 until 10_000) {
            carrier.burst()
        }
        return carrier.infections
    }

    enum class NodeStatus {
        CLEAN, WEAKENED, INFECTED, FLAGGED;

        fun modify() =
                when (this) {
                    CLEAN -> WEAKENED
                    WEAKENED -> INFECTED
                    INFECTED -> FLAGGED
                    FLAGGED -> CLEAN
                }
    }

    data class Carrier2(var x: Int, var y: Int, var dir: Direction, val infectionMap: MutableMap<Node, NodeStatus>, var infections: Int = 0) {
        fun burst() {
            val currentNode = Node(x, y)
            val currentNodeStatus = infectionMap.getValue(currentNode)
            dir = when (currentNodeStatus) {
                NodeStatus.CLEAN -> dir.left()
                NodeStatus.WEAKENED -> dir
                NodeStatus.INFECTED -> dir.right()
                NodeStatus.FLAGGED -> dir.right().right()
            }
            val newNodeStatus = currentNodeStatus.modify()
            if (newNodeStatus == NodeStatus.INFECTED) {
                infections++
            }
            infectionMap.put(currentNode, newNodeStatus)

            when (dir) {
                Direction.UP -> y--
                Direction.DOWN -> y++
                Direction.LEFT -> x--
                Direction.RIGHT -> x++
            }
        }
    }

    fun part2(input: List<String>): Int {
        val infectionMap = mutableMapOf<Node, NodeStatus>().withDefault { NodeStatus.CLEAN }
        input.forEachIndexed { indexY, s ->
            s.forEachIndexed { indexX, c ->
                val nodeStatus = if (c == '#') NodeStatus.INFECTED else NodeStatus.CLEAN
                val node = Node(indexX - (input.size - 1) / 2, indexY - (s.length - 1) / 2)
                infectionMap.put(node, nodeStatus)
            }
        }
        val carrier = Carrier2(0, 0, Direction.UP, infectionMap)
        for (iteration in 0 until 10_000_000) {
            carrier.burst()
        }
        return carrier.infections
    }


}

