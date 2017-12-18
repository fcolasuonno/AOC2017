import kotlin.concurrent.thread

object Day18 {


    fun part1(input: List<String>): Long {
        val regs = mutableMapOf<String, Long>().withDefault { 0L }
        var output = 0L
        var recover = 0L
        while (recover == 0L) {
            var pc = regs.getValue("pc")
            val inst = input[pc.toInt()].split(" ")
            val op = inst[0]
            val reg = inst[1]
            val value = value(regs, if (inst.size == 3) inst[2] else inst[1])
            when (op) {
                "snd" -> output = value
                "set" -> regs[reg] = value
                "add" -> regs[reg] = regs.getValue(reg) + value
                "mul" -> regs[reg] = regs.getValue(reg) * value
                "mod" -> regs[reg] = regs.getValue(reg) % value
                "rcv" -> if (value != 0L) {
                    recover = output
                    return recover
                }
                "jgz" -> if (value(regs, reg) > 0) pc += value - 1
            }
            regs.put("pc", pc + 1)
        }
        return recover
    }

    private fun value(regs: MutableMap<String, Long>, operand: String) =
            if (operand[0].isLetter()) regs.getValue(operand) else operand.toLong()

    fun part2(input: List<String>): Int {
        val queue = arrayListOf(arrayListOf(), arrayListOf<Long>())
        var output = 0
        val program0 = thread(start = true) {
            exec(input, 0, queue)
        }
        val program1 = thread(start = true) {
            output = exec(input, 1, queue)
        }
        program0.join()
        program1.join()
        return output
    }

    private fun exec(input: List<String>, programId: Int, queue: ArrayList<ArrayList<Long>>): Int {
        var count = 0
        val regs = mutableMapOf<String, Long>().withDefault { 0L }
        regs["p"] = programId.toLong()
        while (regs.getValue("pc") < input.size) {
            var pc = regs.getValue("pc")
            val inst = input[pc.toInt()].split(" ")
            val op = inst[0]
            val reg = inst[1]
            val value = value(regs, if (inst.size == 3) inst[2] else inst[1])
            when (op) {
                "snd" -> {
                    queue[(programId + 1) % 2].add(value)
                    count++
                }
                "set" -> regs[reg] = value
                "add" -> regs[reg] = regs.getValue(reg) + value
                "mul" -> regs[reg] = regs.getValue(reg) * value
                "mod" -> regs[reg] = regs.getValue(reg) % value
                "rcv" -> {
                    val myQueue = queue[programId]
                    while (myQueue.isEmpty()) {
                        Thread.sleep(1000)
                        if (queue.all { it.size == 0 }) return count
                    }
                    println(myQueue.size)
                    regs[reg] = myQueue.removeAt(0)
                }
                "jgz" -> if (value(regs, reg) > 0) pc += value - 1
            }
            regs.put("pc", pc + 1)
        }
        return count
    }
}