package day05

import println
import readInput

fun main() {
    fun part1(input: List<String>): Long {
        val (ranges, ids) = parseInput(input)
        return ids.count { id -> ranges.any { r -> id in r } }.toLong()
    }

    fun part2(input: List<String>): Long {
        val ranges = parseInput(input).first.toMutableList()
        var i = 0
        loop@ while (i < ranges.size) {
            val r = ranges[i]
            for (j in i + 1 until ranges.size) {
                val l = ranges[j]
                if (r.last >= l.first && r.first <= l.last) {
                    val newRange = minOf(r.first, l.first)..maxOf(r.last, l.last)
                    ranges[i] = newRange
                    ranges.removeAt(j)
                    continue@loop
                }
            }
            i++
        }
        return ranges.sumOf { it.last - it.first + 1 }
    }


    // Test if implementation meets criteria from the description, like:
//    check(part1(listOf("Day01_test_desc")) == 1)

    // Or read a large test input from the `src/Day04_test.txt` file:
    val testInput = readInput("day05/Day05_test")
    check(part1(testInput).println() == 3L)
//    check(part2(testInput).println() == 4174379265L)

    // Read the input from the `src/Day04.txt` file.
    val input = readInput("day05/Day05")
    part1(input).println()
    part2(input).println()
}

fun parseInput(input: List<String>): Pair<List<LongRange>, List<Long>> {
    val (ranges, ids) = (input - "").partition { it.contains('-') }
    return ranges.map {
        val (start, end) = it.split('-').map { it.toLong() }
        start..end
    } to ids.map { it.toLong() }

}
