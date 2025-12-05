package day03

import println
import readInput

fun main() {
    fun part1(input: List<String>): Long {
        return input.sumOf { line ->
            val chars = line.toCharArray()
            val max = chars.dropLast(1).max()
            val secondMax = chars.drop(chars.indexOf(max)+1).max()
            (max.digitToInt() * 10L + secondMax.digitToInt())
        }
    }

    fun part2(input: List<String>): Long {
        return input.sumOf { line ->
            val chars = line.toCharArray()
            var sum = 0L
            var maxIndex = -1
            for (i in 1 .. 12) {
                val chunk = chars.drop(maxIndex + 1).dropLast(12 - i)
                val max = chunk.max()
                maxIndex += chunk.indexOf(max) + 1
                var jolt = max.digitToInt().toLong()
                repeat(12 - i) {
                    jolt *= 10L
                }
                sum += jolt
            }
            sum
        }
    }


    // Test if implementation meets criteria from the description, like:
//    check(part1(listOf("Day01_test_desc")) == 1)

    // Or read a large test input from the `src/Day03_test.txt` file:
    val testInput = readInput("day03/Day03_test")
    check(part1(testInput).println() == 357L)
//    check(part2(testInput).println() == 4174379265L)

    // Read the input from the `src/Day03.txt` file.
    val input = readInput("day03/Day03")
    part1(input).println()
    part2(input).println()
}

