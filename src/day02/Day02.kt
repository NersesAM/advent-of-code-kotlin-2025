package day02

import println
import readInput
import kotlin.math.absoluteValue

fun main() {
    fun part1(input: List<String>): Long {
        return parseInput(input).fold(0L) { acc, pair ->
            var count = 0L
            for (i in pair.first .. pair.second) {
                val iStr = i.toString()
                if (iStr.length % 2 == 1) continue
                if (iStr.take(iStr.length / 2).toInt() == iStr.drop(iStr.length / 2).toInt())
                    count+=i
            }
            acc + count
        }
    }

    fun part2(input: List<String>): Long {
        return parseInput(input).fold(0L) { acc, pair ->
            var count = 0L
            loop@for (i in pair.first .. pair.second) {
                val iStr = i.toString()
                for (j in 1 .. iStr.length/2) {
                    val chunked = iStr.chunked(j)
                    if (chunked.all { it == chunked.first() }) {
                        count += i.also { println(i) }
                        continue@loop
                    }
                }
            }
            acc + count
        }
    }


    // Test if implementation meets criteria from the description, like:
//    check(part1(listOf("Day01_test_desc")) == 1)

    // Or read a large test input from the `src/Day02_test.txt` file:
    val testInput = readInput("day02/Day02_test")
    check(part1(testInput).println() == 1227775554L)
    check(part2(testInput).println() == 4174379265L)

    // Read the input from the `src/Day02.txt` file.
    val input = readInput("day02/Day02")
    part1(input).println()
    part2(input).println()
}

fun parseInput(input: List<String>): List<Pair<Long, Long>> {
    return input[0].split(',').map {
        val splits = it.split('-')
        splits.first().toLong() to splits.last().toLong()
    }
}
