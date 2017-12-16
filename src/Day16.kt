object Day16 {

    fun part1(instructions: List<String>, size: Int = 16): String = Array(size, { index -> 'a' + index })
            .let { line ->
                instructions.forEach {
                    when (it[0]) {
                        's' -> {
                            val pos = it.substring(1).toInt()
                            val head = line.sliceArray(size - pos until size)
                            val tail = line.sliceArray(0 until size - pos)
                            head.forEachIndexed { index, c -> line[index] = c }
                            tail.forEachIndexed { index, c -> line[index + pos] = c }
                        }
                        'x' -> {
                            val (from, to) = it.substring(1).split('/').map { it.toInt() }
                            val dest = line[to]
                            line[to] = line[from]
                            line[from] = dest
                        }
                        'p' -> {
                            val (from, to) = it.substring(1).split('/').map { line.indexOf(it[0]) }
                            val dest = line[to]
                            line[to] = line[from]
                            line[from] = dest
                        }
                    }
                }
                line
            }.joinToString("")


    fun part2slow(instructions: List<String>, size: Int = 16, iterations: Int = 1): String = Array(size, { index -> 'a' + index })
            .let { line ->
                for (i in 0 until iterations)
                    instructions.forEach {
                        when (it[0]) {
                            's' -> {
                                val pos = it.substring(1).toInt()
                                val head = line.sliceArray(size - pos until size)
                                val tail = line.sliceArray(0 until size - pos)
                                head.forEachIndexed { index, c -> line[index] = c }
                                tail.forEachIndexed { index, c -> line[index + pos] = c }
                            }
                            'x' -> {
                                val (from, to) = it.substring(1).split('/').map { it.toInt() }
                                val dest = line[to]
                                line[to] = line[from]
                                line[from] = dest
                            }
                            'p' -> {
                                val (from, to) = it.substring(1).split('/').map { line.indexOf(it[0]) }
                                val dest = line[to]
                                line[to] = line[from]
                                line[from] = dest
                            }
                        }
                    }
                line
            }.joinToString("")

    fun part2(instructions: List<String>, size: Int = 16, iterations: Int = 1): String = Array(size, { index -> 'a' + index })
            .let { line ->
                val permutations = Array(size, { i -> i })
                val transformations = Array(size, { i -> 'a' + i })
                instructions.forEach {
                    when (it[0]) {
                        's' -> {
                            val pos = it.substring(1).toInt()
                            val head = permutations.sliceArray(size - pos until size)
                            val tail = permutations.sliceArray(0 until size - pos)
                            head.forEachIndexed { index, c -> permutations[index] = c }
                            tail.forEachIndexed { index, c -> permutations[index + pos] = c }
                        }
                        'x' -> {
                            val (from, to) = it.substring(1).split('/').map { it.toInt() }
                            val dest = permutations[to]
                            permutations[to] = permutations[from]
                            permutations[from] = dest
                        }
                        'p' -> {
                            val (from, to) = it.substring(1).split('/').map { transformations.indexOf(it[0]) }
                            val dest = transformations[to]
                            transformations[to] = transformations[from]
                            transformations[from] = dest
                        }
                    }
                }
                val permut = permutations.toList()

                for (i in 0 until iterations) {
                    line.sliceArray(permut).forEachIndexed { index, c -> line[index] = c }
                    line.forEachIndexed { index, c -> line[index] = transformations[c - 'a'] }
                }
                line
            }.joinToString("")

    fun part2Faster(instructions: List<String>, size: Int = 16, iterations: Int = 1): String = Array(size, { index -> 'a' + index })
            .let { line ->
                val permutations = Array(size, { i -> i })
                val transformations = Array(256, { i -> i })
                instructions.forEach {
                    when (it[0]) {
                        's' -> {
                            val pos = it.substring(1).toInt()
                            val head = permutations.sliceArray(size - pos until size)
                            val tail = permutations.sliceArray(0 until size - pos)
                            head.forEachIndexed { index, c -> permutations[index] = c }
                            tail.forEachIndexed { index, c -> permutations[index + pos] = c }
                        }
                        'x' -> {
                            val (from, to) = it.substring(1).split('/').map { it.toInt() }
                            val dest = permutations[to]
                            permutations[to] = permutations[from]
                            permutations[from] = dest
                        }
                        'p' -> {
                            val (from, to) = it.substring(1).split('/').map { transformations.indexOf(it[0].toInt()) }
                            val dest = transformations[to]
                            transformations[to] = transformations[from]
                            transformations[from] = dest
                        }
                    }
                }

                val p = permutations.toIntArray()
                val t = transformations.toIntArray()
                val a1 = line.map { it.toInt() }.toIntArray()
                val a2 = a1.clone()

                for (iter in 0 until iterations) {
                    if (iter % 2 == 0) {
                        for (i in 0 until size) {
                            a1[i] = t[a2[p[i]]]
                        }
                    } else {
                        for (i in 0 until size) {
                            a2[i] = t[a1[p[i]]]
                        }
                    }
                }
                (if (iterations % 2 == 1) a1 else a2).map { it.toChar() }.joinToString("")
            }
}

