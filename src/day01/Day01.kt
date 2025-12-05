package day01

import println
import readInput
import kotlin.math.absoluteValue

fun main() {
    fun part1(input: List<String>): Int {
        var position = 50
        return parseInput(input).sumOf {
            position += it
            position = ((position % 100) + 100) % 100
            if (position == 0) 1 else 0
        }
    }

    fun part2(input: List<String>): Int {
        var position = 50
        return parseInput(input).sumOf {
            val startingPosition = position
            position += it
            var clicks = position.absoluteValue / 100
            position = (position % 100)
            if (position < 0) {
                position += 100
                if (startingPosition != 0) clicks++
            } else if (position == 0 && (clicks == 0 || it < 0)) {
                clicks++
            }

            clicks
        }
    }


    // Test if implementation meets criteria from the description, like:
//    check(part1(listOf("Day01_test_desc")) == 1)

    // Or read a large test input from the `src/Day01_test.txt` file:
    val testInput = readInput("day01/Day01_test")
    check(part1(testInput).println() == 3)
    check(part2(testInput).println() == 6)

    // Read the input from the `src/Day01.txt` file.
    val input = readInput("day01/Day01")
    part1(input).println()
    part2(input).println()
}

fun parseInput(input: List<String>): List<Int> {
    return input.map {
        val value = it.substring(1).toInt()
        when (it[0]) {
            'L' -> -value
            'R' -> value
            else -> throw IllegalArgumentException("Unknown direction ${it[0]}")
        }
    }
}
