class Day4 {

    fun part1(input: List<String>) = input.count { passphrase ->
        passphrase.split(" ").let { word ->
            word.toSet().size == word.size
        }
    }

    fun part2(input: List<String>) = input.count { passphrase ->
        passphrase.split(" ").let { word ->
            word.map { it -> it.toCharArray().sortedArray().contentToString() }.toSet().size == word.size
        }
    }

}