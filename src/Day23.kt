object Day23 {

    private fun value(regs: MutableMap<String, Long>, operand: String) =
            if (operand[0].isLetter()) regs.getValue(operand) else operand.toLong()

    fun part1(input: List<String>): Long {
        val regs = mutableMapOf<String, Long>().withDefault { 0L }
        var output = 0L
        while (regs.getValue("pc") < input.size) {
            var pc = regs.getValue("pc")
            val inst = input[pc.toInt()].split(" ")
            val op = inst[0]
            val reg = inst[1]
            val value = value(regs, if (inst.size == 3) inst[2] else inst[1])
            when (op) {
                "set" -> regs[reg] = value
                "sub" -> regs[reg] = regs.getValue(reg) - value
                "mul" -> {
                    regs[reg] = regs.getValue(reg) * value
                    output++
                }
                "jnz" -> if (value(regs, reg) != 0L) pc += value - 1
            }
            regs.put("pc", pc + 1)
        }
        return output
    }


    fun asmInterpreted(input: List<String>, regB: Int? = null, regC: Int? = null): Int {
        val regs = mutableMapOf<String, Long>().withDefault { 0L }
        regs["a"] = 1L

        var output = 0L
        while (regs.getValue("pc") < input.size) {
            var pc = regs.getValue("pc")
            val inst = input[pc.toInt()].split(" ")
            val op = inst[0]
            val reg = inst[1]

            var value = value(regs, if (inst.size == 3) inst[2] else inst[1])
            if (regC != null && pc == 7L) {
                value = -regC.toLong()
            }
            when (op) {
                "set" -> regs[reg] = value
                "sub" -> regs[reg] = regs.getValue(reg) - value
                "mul" -> {
                    regs[reg] = regs.getValue(reg) * value
                    output++
                }
                "jnz" -> if (value(regs, reg) != 0L) pc += value - 1
            }
            regs.put("pc", pc + 1)
            if (regB != null && pc == 4L) {
                regs["b"] = regB - 100000L
            }
        }
        return regs.getValue("h").toInt()
    }

    fun asmEquivalent(regB: Int, regC: Int): Int {

        val isPrime = BooleanArray(125_000) { true }
        (2..360) // 360 ~= sqrt(125_000)
                .filter { isPrime[it] }
                .flatMap { (2 * it) until 125_000 step it } //sieve
                .forEach { isPrime[it] = false }

        return (regB..(regB + regC) step 17).count { !isPrime[it] }
    }

}