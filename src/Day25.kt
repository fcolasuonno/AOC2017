object Day25 {

    data class State(val name: String, private val action0: Triple<Boolean, Boolean, String>, private val action1: Triple<Boolean, Boolean, String>) {
        fun step(ones: HashSet<Int>, currentState: Pair<String, Int>): Pair<String, Int> {
            var cursor = currentState.second
            val action = if (ones.contains(cursor)) action1 else action0
            if (action.first) ones.add(cursor) else ones.remove(cursor)
            if (action.second) cursor++ else cursor--
            return Pair(action.third, cursor)
        }
    }

    fun part1(input: List<String>): Int {
        val cursor = 0
        val initialState = "state ([A-Z]+)".toRegex().find(input[0])?.groupValues?.get(1) ?: "A"
        var currentState = Pair(initialState, cursor)
        val steps = "after ([0-9]+) steps".toRegex().find(input[1])?.groupValues?.get(1)?.toInt() ?: 1
        val tapeOnes = hashSetOf<Int>()
        val stateMap = (3..input.size step 10).map { i ->
            val stateName = "state ([A-Z]+)".toRegex().find(input[i])?.groupValues?.get(1) ?: "A"
            val action0 = action(input, i + 1)
            val action1 = action(input, i + 5)
            State(stateName, action0, action1)
        }.associateBy { it.name }
        for (step in 0 until steps) {
            currentState = stateMap[currentState.first]!!.step(tapeOnes, currentState)
        }
        return tapeOnes.count()
    }

    private fun action(input: List<String>, i: Int): Triple<Boolean, Boolean, String> {
        val write = "Write the value 1".toRegex().containsMatchIn(input[i + 1])
        val moveRight = "Move one slot to the right".toRegex().containsMatchIn(input[i + 2])
        val nextState = "state ([A-Z]+)".toRegex().find(input[i + 3])?.groupValues?.get(1) ?: "A"
        return Triple(write, moveRight, nextState)
    }

}
