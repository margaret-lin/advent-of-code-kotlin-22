package main.kotlin

import java.io.File

fun main() {
    val input = File("src/main/resources/day06_input.txt").readText()
    println(part1(input))
    println(part2(input))

}
fun solution(input: String, length: Int) = input.windowed(length)
    .indexOfFirst { it.toSet().size == length } + length
// the size of "distinguished set should be the length of example 4
// if there is duplicates, the "Set" would be less than 4 bcuz it only returns non duplicates
// add length in the end because we use indexOfFirst, but we want the last index
// mjqjpqmgbljsphdztnvjfqwrcgsmlb -> first index of distinguished element is 3, then we add the length of window 4 == 7

private fun part1(input: String) = solution(input, 4)

private fun part2(input: String) = solution(input, 14)