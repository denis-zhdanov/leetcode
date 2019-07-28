package org.denis.leetcode.p1138

import kotlin.test.assertEquals

fun main() {
    assertEquals("DDR!UURRR!!DDD!", alphabetBoardPath("leet"))
}

val board = listOf(
        "abcde",
        "fghij",
        "klmno",
        "pqrst",
        "uvwxy",
        "z"
)

fun alphabetBoardPath(target: String): String {
    val (symbols, points) = buildData()
    val current = mutableListOf(Path("", Point(0, 0)))
    val next = mutableListOf<Path>()
    for (c in target) {
        for (path in current) {
            next += solve(symbols, points, path, c)
        }
        current.clear()
        current += next
        next.clear()
    }
    return current.minBy { it.path.length }?.path ?: ""
}

private fun buildData(): Pair<Map<Char, Collection<Point>>, Set<Point>> {
    val symbols = mutableMapOf<Char, MutableCollection<Point>>()
    val points = mutableSetOf<Point>()
    board.forEachIndexed { rowIndex, rowSymbols ->
        rowSymbols.forEachIndexed { columnIndex, symbol ->
            val point = Point(rowIndex, columnIndex)
            symbols.getOrPut(symbol) { mutableListOf() } += point
            points += point
        }
    }
    return symbols to points
}

private fun solve(
        symbols: Map<Char, Collection<Point>>,
        availablePoints: Set<Point>,
        currentPath: Path,
        symbol: Char
): Collection<Path> {
    return symbols[symbol]?.map { pointTo ->
        val buffer = StringBuilder()
        var from = currentPath.end
        while (from != pointTo) {
            val (command, newPoint) = move(from, pointTo, availablePoints)
            buffer.append(command)
            from = newPoint
        }
        buffer.append("!")
        Path(currentPath.path + buffer.toString(), pointTo)
    } ?: emptyList()
}

private fun move(from: Point, to: Point, availablePoints: Set<Point>): Pair<String, Point> {
    if (from.x < to.x) {
        val candidate = Point(from.x + 1, from.y)
        if (availablePoints.contains(candidate)) {
            return "D" to candidate
        }
    }
    if (from.x > to.x) {
        val candidate = Point(from.x - 1, from.y)
        if (availablePoints.contains(candidate)) {
            return "U" to candidate
        }
    }
    if (from.y < to.y) {
        val candidate = Point(from.x, from.y + 1)
        if (availablePoints.contains(candidate)) {
            return "R" to candidate
        }
    }

    return "L" to Point(from.x, from.y - 1)
}

data class Point(val x: Int, val y: Int)
data class Path(val path: String, val end: Point)