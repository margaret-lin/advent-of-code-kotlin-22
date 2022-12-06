package main.kotlin

import main.kotlin.Gesture.*
import main.kotlin.Outcome.*


/*
* this solution is credited to Sebastian from Advent of Code 2022 live stream
* */

fun main() {
    println(part1())
    println(part2())
}


private var input = readInput("day02_input").map {
    val (a, b) = it.split(" ")
    a[0] to b[0]

    // [(A, Y), (B, X), (C, Z)]
}

private fun part1(): Int {
    return input.sumOf { (opponent, you) ->
        calculateScore(opponent.toGesture(), you.toGesture())
    }
}

private fun part2(): Int {
    return input.sumOf { (opponent, you) ->
        val yourHand = handForDesiredOutcome(opponent.toGesture(), you.toOutcome())
        calculateScore(opponent.toGesture(), yourHand)
    }
}


private fun calculateScore(opponent: Gesture, me: Gesture): Int {
    val outcome = calculateOutcome(me, opponent)
    return me.points + outcome.points
}

enum class Outcome(val points: Int) {
    WIN(6),
    DRAW(3),
    LOSS(0)
}

private fun calculateOutcome(first: Gesture, second: Gesture): Outcome = when {
    first == second -> DRAW
    first.beats() == second -> WIN
    else -> LOSS
}

private fun handForDesiredOutcome(opponent: Gesture, desiredOutcome: Outcome): Gesture {
    return when (desiredOutcome) {
        DRAW -> opponent
        LOSS -> opponent.beats()
        WIN -> opponent.beatenBy()
    }
}

fun Gesture.beatenBy(): Gesture {
    return when (this) {
        SCISSORS -> ROCK
        ROCK -> PAPER
        PAPER -> SCISSORS
    }
}

fun Gesture.beats(): Gesture {
    return when (this) {
        ROCK -> SCISSORS
        PAPER -> ROCK
        SCISSORS -> PAPER
    }
}

fun Char.toGesture(): Gesture {
    return when (this) {
        'A', 'X' -> ROCK
        'B', 'Y' -> PAPER
        'C', 'Z' -> SCISSORS
        else -> error("Unknown main.kotlin.input $this")
    }
}

fun Char.toOutcome(): Outcome {
    return when (this) {
        'X' -> LOSS
        'Y' -> DRAW
        'Z' -> WIN
        else -> error("Unknown main.kotlin.input $this")
    }
}

enum class Gesture(val points: Int) {
    ROCK(1),
    PAPER(2),
    SCISSORS(3)
}
