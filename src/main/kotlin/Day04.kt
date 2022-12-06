package main.kotlin

fun main() {
    println(part1(input))
}

private val input = readInput("day04_input")


private fun part1(input: List<String>): Pair<Int, Int> {
    val sectionPairs = input.map { line ->
        val sections = line.split(",") // [2-4, 6-8]
        val (sectionA, sectionB) = sections.map { rangeString ->
            val (from, to) = rangeString.split("-").map { it.toInt() } // [2, 4]
            (from..to).toSet() // [2, 3, 4]
        }

        sectionA to sectionB// create Pair [2, 3, 4] [6, 7, 8]
    }

    val fullyOverlapping = sectionPairs.count { (a, b) ->
        a.containsAll(b) || b.containsAll(a)
    }

    val overlapping = sectionPairs.count { (a, b) ->
        a.intersect(b).isNotEmpty()
    }

    return fullyOverlapping to overlapping
}




