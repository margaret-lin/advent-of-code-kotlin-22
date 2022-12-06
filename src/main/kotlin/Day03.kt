package main.kotlin// https://adventofcode.com/2022/day/3

private val input = readInput("day03_input")

private fun part1(input: List<String>): Int {
    return input.map { it.take(it.length / 2) to it.substring(it.length / 2) }
        .map { (it.first.toSet() intersect it.second.toSet()).single() }
        .sumOf(Char::getPriority)
}

//private fun part2(main.kotlin.input: List<String>): Int {
//    return main.kotlin.input.map(String::toSet)
//        .chunked(3)
//        .map { it.reduce(Set<Char>::main.kotlin.intersect).single() }
//        .sumOf(Char::main.kotlin.getPriority) //same as sumOf { it.main.kotlin.getPriority() }
//}

// solution from Sebastian
private fun part2Sebastian(input: List<String>): Int {
    val badges = input.chunked(3) {
        val (a, b, c) = it
        val badge = a.toSet() intersect  b.toSet() intersect  c.toSet()
        badge.single()
    }
    return badges.sumOf { it.getPriority() }
}

//val Char.main.kotlin.getPriority
//        get(): Int {
//            return if (isLowerCase()) {
//                this - 'a' + 1
//            } else {
//                this - 'A' + 27
//            }
//        }
// to have fewer manuel calls to `toSet()`
 infix fun String.intersect(other: String) = toSet() intersect  other.toSet()

private fun Char.getPriority() = (('a'..'z') + ('A'..'Z')).indexOf(this) + 1



fun main() {
    println(part1(input))
    println(part2Sebastian(input))
}

//var main.kotlin.input = main.kotlin.readInput("day03_test_input ").map {
//    it.chunked(it.length / 2)
//}

// we need to split line in half -> modulo or remainder -> chuncked!
// we need to compare split array 1 and array 2, find the identical item(character)
// we need to convert the found char to ASCII
// we need to add all nums together