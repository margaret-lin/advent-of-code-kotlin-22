package main.kotlin

import java.io.File

// https://adventofcode.com/2022/day/1

fun main() {
    // we operate on the double lines when reading the file

    fun parseInput(input: String) = input.split("\n\n").map { elf ->
        elf.lines().map { it.toInt() }
    }

    fun List<List<Int>>.topNElves(n: Int): Int {
        return map { it.sum() }
            .sortedDescending()
            .take(n)
            .sum()
    }

    fun part1(input: String): Int {

        val data = parseInput(input)

        return data.topNElves(1)
    }

    fun part2(input: String): Int {
        // we do the same parsing, then sort the array in descend order, then take the first 3 and sum them.

        val data = parseInput(input)

        return data.topNElves(3)
    }




    val testInput = File("src/main/resources/day01_test_input.txt").readText()
    check(part1(testInput) == 24000)
//    println(testInput.split("\n\n"))



    val input = File("src/main/resources/day01_input.txt").readText()
    println(part1(input))
    println(part2(input))


}