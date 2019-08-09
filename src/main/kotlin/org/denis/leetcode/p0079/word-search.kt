package org.denis.leetcode.p0079

import kotlin.test.assertFalse
import kotlin.test.assertTrue

fun main() {
    assertTrue(exist(arrayOf(
            "ABCE".toCharArray(),
            "SFCS".toCharArray(),
            "ADEE".toCharArray()
    ), "ABCCED"))
    assertTrue(exist(arrayOf(
            "ABCE".toCharArray(),
            "SFCS".toCharArray(),
            "ADEE".toCharArray()
    ), "SEE"))
    assertFalse(exist(arrayOf(
            "ABCE".toCharArray(),
            "SFCS".toCharArray(),
            "ADEE".toCharArray()
    ), "ABCB"))
    assertTrue(exist(arrayOf(
            charArrayOf('a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a'),
            charArrayOf('a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a'),
            charArrayOf('a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a'),
            charArrayOf('a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a'),
            charArrayOf('a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a'),
            charArrayOf('a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a'),
            charArrayOf('a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a'),
            charArrayOf('a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a'),
            charArrayOf('a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a'),
            charArrayOf('a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a'),
            charArrayOf('a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a'),
            charArrayOf('a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a'),
            charArrayOf('a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a'),
            charArrayOf('a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a'),
            charArrayOf('a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a'),
            charArrayOf('a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a'),
            charArrayOf('a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a'),
            charArrayOf('a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a'),
            charArrayOf('a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a'),
            charArrayOf('a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a'),
            charArrayOf('a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a'),
            charArrayOf('a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a'),
            charArrayOf('a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a'),
            charArrayOf('a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a'),
            charArrayOf('a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a'),
            charArrayOf('a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a'),
            charArrayOf('a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a'),
            charArrayOf('a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a'),
            charArrayOf('a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a'),
            charArrayOf('a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','b')
    ), "baaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"))
}

fun exist(board: Array<CharArray>, word: String): Boolean {
    if (word.isEmpty()) {
        return true
    }
    val points = mutableMapOf<Point, Char>()
    val firstSymbol = word.first()
    val firstPositions = mutableListOf<Point>()
    val actualCounts = mutableMapOf<Char, Int>()
    for (row in 0 until board.size) {
        for (column in 0 until board[row].size) {
            val symbol = board[row][column]
            val point = Point(row, column)
            points[point] = symbol
            val prev = actualCounts.getOrDefault(symbol, 0)
            actualCounts[symbol] = prev + 1
            if (firstSymbol == symbol) {
                firstPositions += point
            }
        }
    }
    for (symbol in word) {
        val currentCount = actualCounts[symbol]
        if (currentCount == null || currentCount <= 0) {
            return false
        }
        actualCounts[symbol] = currentCount - 1
    }

    return firstPositions.any {
        solve(word, 1, it, points)
    }
}

private fun solve(
        word: String,
        i: Int,
        tailPosition: Point,
        board: MutableMap<Point, Char>
): Boolean {
    if (i >= word.length) {
        return true
    }
    val nextSymbol = word[i]
    for (neighbourPoint in tailPosition.neighbours) {
        if (board[neighbourPoint] == nextSymbol) {
            board.remove(neighbourPoint)
            val result = solve(word, i + 1, neighbourPoint, board)
            board[neighbourPoint] = nextSymbol
            if (result) {
                return true
            }
        }
    }
    return false
}

data class Point(val row: Int, val column: Int) {
    val neighbours: Collection<Point>
        get() {
            return listOf(Point(row - 1, column),
                          Point(row + 1, column),
                          Point(row, column - 1),
                          Point(row, column + 1))
        }
}