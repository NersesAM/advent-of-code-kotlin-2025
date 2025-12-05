package day04

import println
import readInput

fun main() {
    fun part1(input: List<String>): Long {
        val coords = parseInput(input).toSet()
        var count = 0L
        for (c in coords) {
            if (c.neighbors().count { coords.contains(it) } < 4) {
                count++

            }
        }
        return count
    }

    fun part2(input: List<String>): Long {
        val coords = parseInput(input).toMutableSet()
        var count = 0L
        while(true) {
            val removable = mutableSetOf<Coord>()
            for (c in coords) {
                if (c.neighbors().count { coords.contains(it) } < 4) {
                    count++
                    removable.add(c)
                }
            }
            if (removable.isEmpty()) break else coords.removeAll(removable)
        }
        return count
    }


    // Test if implementation meets criteria from the description, like:
//    check(part1(listOf("Day01_test_desc")) == 1)

    // Or read a large test input from the `src/Day04_test.txt` file:
    val testInput = readInput("day04/Day04_test")
    check(part1(testInput).println() == 13L)
//    check(part2(testInput).println() == 4174379265L)

    // Read the input from the `src/Day04.txt` file.
    val input = readInput("day04/Day04")
    part1(input).println()
    part2(input).println()
}

fun parseInput(input: List<String>): List<Coord> {
    return input.foldIndexed(mutableListOf<Coord>()) { i, acc, line ->
        line.foldIndexed(acc) { j, acc2, c ->
            if (c == '@') acc2.add(Coord(i, j))
            acc2
        }
        acc
    }


}

sealed class Cell
object Roll : Cell()
object Empty : Cell()

data class Coord(val x: Int, val y: Int)
fun Coord.neighbors(): List<Coord> {
    return listOf(
        Coord(x - 1, y - 1),
        Coord(x - 1, y),
        Coord(x - 1, y + 1),
        Coord(x, y - 1),
        Coord(x, y + 1),
        Coord(x + 1, y - 1),
        Coord(x + 1, y),
        Coord(x + 1, y + 1),
    )
}
