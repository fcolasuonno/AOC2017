class Day8 {

    fun part1(input: List<String>) = mutableMapOf<String, Int>().let { registers ->
        input.forEach { inputLine ->
            val matchResult = """([a-z]+) (inc|dec) ([+\-0-9]+) if ([a-z]+) ([><=!]+) ([+\-0-9]+)""".toRegex().matchEntire(inputLine)
            if (matchResult == null) {
                throw Exception("not matched " + inputLine)
            } else {
                val (register, operation, amount, conditionReg, conditionOperation, conditionString) = matchResult.destructured
                val conditionValue = conditionString.toInt()
                val registerValue = registers[conditionReg] ?: 0
                val condition = when (conditionOperation) {
                    ">" -> registerValue > conditionValue
                    ">=" -> registerValue >= conditionValue
                    "<" -> registerValue < conditionValue
                    "<=" -> registerValue <= conditionValue
                    "==" -> registerValue == conditionValue
                    "!=" -> registerValue != conditionValue
                    else -> false
                }
                if (condition) {
                    val currentValue = registers[register] ?: 0
                    val newValue = when (operation) {
                        "inc" -> currentValue + amount.toInt()
                        else -> currentValue - amount.toInt()
                    }
                    registers[register] = newValue
                }
            }
        }
        registers.values.max()
    }

    fun part2(input: List<String>) = mutableMapOf<String, Int>().let { registers ->
        var max = Int.MIN_VALUE
        input.forEach { inputLine ->
            val matchResult = """([a-z]+) (inc|dec) ([+\-0-9]+) if ([a-z]+) ([><=!]+) ([+\-0-9]+)""".toRegex().matchEntire(inputLine)
            if (matchResult == null) {
                throw Exception("not matched " + inputLine)
            } else {
                val (register, operation, amount, conditionReg, conditionOperation, conditionString) = matchResult.destructured
                val conditionValue = conditionString.toInt()
                val registerValue = registers[conditionReg] ?: 0
                val condition = when (conditionOperation) {
                    ">" -> registerValue > conditionValue
                    ">=" -> registerValue >= conditionValue
                    "<" -> registerValue < conditionValue
                    "<=" -> registerValue <= conditionValue
                    "==" -> registerValue == conditionValue
                    "!=" -> registerValue != conditionValue
                    else -> false
                }
                if (condition) {
                    val currentValue = registers[register] ?: 0
                    val newValue = when (operation) {
                        "inc" -> currentValue + amount.toInt()
                        else -> currentValue - amount.toInt()
                    }
                    registers[register] = newValue
                    max = Math.max(max, newValue)
                }
            }
        }
        max
    }
}