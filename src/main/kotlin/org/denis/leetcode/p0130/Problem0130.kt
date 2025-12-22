package org.denis.leetcode.p0130

import java.util.Stack
import kotlin.test.assertTrue

fun main() {
    test(
        """[["O","X","X","O","X"],["X","O","O","X","O"],["X","O","X","O","X"],["O","X","O","O","O"],["X","X","O","X","O"]]""",
        """[["O","X","X","O","X"],["X","X","X","X","O"],["X","X","X","O","X"],["O","X","O","O","O"],["X","X","O","X","O"]]"""
    )
    test(
        """[["X","O","X"],["O","X","O"],["X","O","X"]]""",
        """[["X","O","X"],["O","X","O"],["X","O","X"]]"""
    )
    test(
        """[["X"]]""",
        """[["X"]]"""
    )
    test(
        """[["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]""",
        """[["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]"""
    )
}

private fun test(input: String, expected: String) {
    val solution = Solution()
    val parsedInput = parse(input)
    println("input:")
    printBoard(parsedInput)
    solution.solve(parsedInput)
    println()
    println("output:")
    printBoard(parsedInput)
    val parsedExpected = parse(expected)
    assertTrue(parsedExpected.contentDeepEquals(parsedInput))
}

private fun parse(s: String): Array<CharArray> {
    val trimmed = s.replace("[[", "").replace("]]", "")
    return trimmed.split("],[").map { rawRow ->
        rawRow.split(",").map { it.trim('"')[0] }.toCharArray()
    }.toTypedArray()
}

private fun printBoard(board: Array<CharArray>) {
    board.forEach { row ->
        row.forEach { print(it) }
        println()
    }
}

class Solution {
    fun solve(board: Array<CharArray>) {
        if (board.isEmpty() || board[0].isEmpty()) {
            return
        }
        val inspected = mutableSetOf<Pair<Int, Int>>()
        board.forEachIndexed { rowIndex, row ->
            row.forEachIndexed { columnIndex, c ->
                if (c == 'O' && !inspected.contains(rowIndex to columnIndex)) {
                    val (regionCoordinates, surrounded) = parseRegion(board, rowIndex, columnIndex)
                    if (surrounded) {
                        regionCoordinates.forEach { (r, c) -> board[r][c] = 'X' }
                    } else {
                        inspected += regionCoordinates
                    }
                }
            }
        }
    }

    private fun parseRegion(board: Array<CharArray>, rowIndex: Int, columnIndex: Int): Pair<Set<Pair<Int, Int>>, Boolean> {
        val result = mutableSetOf<Pair<Int, Int>>()
        var surrounded = true
        val toProcess = Stack<Pair<Int, Int>>()
        toProcess.push(rowIndex to columnIndex)
        while (toProcess.isNotEmpty()) {
            val point = toProcess.pop()
            result += point
            if (surrounded) {
                surrounded = !isOnEdge(board, point)
            }
            takeIfMatched(board, result, point.first - 1, point.second)?.let { toProcess += it }
            takeIfMatched(board, result, point.first + 1, point.second)?.let { toProcess += it }
            takeIfMatched(board, result, point.first, point.second + 1)?.let { toProcess += it }
            takeIfMatched(board, result, point.first, point.second - 1)?.let { toProcess += it }
        }
        return result to surrounded
    }

    private fun isOnEdge(board: Array<CharArray>, point: Pair<Int, Int>): Boolean {
        return point.first == 0 || point.first == board.size - 1 || point.second == 0 || point.second == board[0].size - 1
    }

    private fun takeIfMatched(board: Array<CharArray>, processed: MutableSet<Pair<Int, Int>>, rowIndex: Int, columnIndex: Int): Pair<Int, Int>? {
        if (rowIndex < 0 || rowIndex >= board.size || columnIndex < 0 || columnIndex >= board[0].size || board[rowIndex][columnIndex] != 'O') {
            return null
        }
        val result = rowIndex to columnIndex
        return result.takeIf { processed.add(it) }
    }
}