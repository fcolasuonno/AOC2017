object Day21 {

    fun part1(input: List<String>, iterations: Int): Int {
        val rules = mutableMapOf<List<List<Char>>, List<List<Char>>>()
        input.forEach {
            val (rule, expansion) = it.split(" => ".toRegex()).map { it.split('/').map { it.toList() } }
            rules[rule] = expansion
            rules[flipH(rule)] = expansion
            rules[flipV(rule)] = expansion
            rules[flipV(flipH(rule))] = expansion
            rules[rotate90(rule)] = expansion
            rules[flipV(rotate90(rule))] = expansion
            rules[flipH(rotate90(rule))] = expansion
            rules[rotate90(rotate90(rotate90(rule)))] = expansion
            rules[flipV(rotate90(rotate90(rotate90(rule))))] = expansion
            rules[flipH(rotate90(rotate90(rotate90(rule))))] = expansion
        }

        var canvas = listOf(
                listOf('.', '#', '.'),
                listOf('.', '.', '#'),
                listOf('#', '#', '#'))
        for (iteration in 0 until iterations) {
            val expanded = splitCanvas(canvas).map {
                it.map { pattern ->
                    with(pattern) {
                        if (!rules.contains(pattern)) {
                            println("Could not find \n")
                            print(pattern)
                        }
                        rules[pattern]!!
                    }
                }
            }
            val newCanvas = mutableListOf<MutableList<Char>>()
            val size = expanded.size
            for (k in 0 until size) {
                for (v in 0 until size) {
                    val sub = expanded[k][v]
                    for (i in 0 until sub.size) {
                        for (j in 0 until sub.size) {
                            if (newCanvas.size <= i + k * sub.size) {
                                newCanvas.add(mutableListOf())
                            }
                            newCanvas.get(i + k * sub.size).add(sub[i][j])
                        }
                    }
                }
            }
            canvas = newCanvas
        }
        return canvas.sumBy { it.count { it == '#' } }
    }

    private fun splitCanvas(canvas: List<List<Char>>): List<List<List<List<Char>>>> {
        val subsV = mutableListOf<List<List<List<Char>>>>()
        if (canvas.size % 2 == 0) {
            for (i in 0 until canvas.size step 2) {
                val subsH = mutableListOf<List<List<Char>>>()
                for (j in 0 until canvas.size step 2) {
                    subsH.add(arrayListOf(canvas[i].subList(j, j + 2), canvas[i + 1].subList(j, j + 2)))
                }
                subsV.add(subsH)
            }
        } else {
            for (i in 0 until canvas.size step 3) {
                val subsH = mutableListOf<List<List<Char>>>()
                for (j in 0 until canvas.size step 3) {
                    subsH.add(arrayListOf(canvas[i].subList(j, j + 3), canvas[i + 1].subList(j, j + 3), canvas[i + 2].subList(j, j + 3)))
                }
                subsV.add(subsH)
            }
        }
        return subsV
    }

    private fun rotate90(pattern: List<List<Char>>): List<List<Char>> {
        return (0 until pattern.size).map { col ->
            pattern.map { it[pattern.size - col - 1] }
        }
    }

    private fun flipV(pattern: List<List<Char>>): List<List<Char>> {
        return pattern.reversed()
    }

    private fun flipH(pattern: List<List<Char>>): List<List<Char>> {
        return pattern.map { it.reversed() }
    }

    private fun print(pattern: List<List<Char>>) {
        println(pattern.map { it.joinToString("") }.joinToString("\n"))
    }
}

