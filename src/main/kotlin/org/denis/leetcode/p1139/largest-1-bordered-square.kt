package org.denis.leetcode.p1139

import kotlin.test.assertEquals

fun main() {
    assertEquals(9, largest1BorderedSquare(arrayOf(
            intArrayOf(0,1,0,1,1),
            intArrayOf(1,1,1,1,1),
            intArrayOf(1,1,0,1,1),
            intArrayOf(1,1,1,1,0),
            intArrayOf(0,1,1,1,1),
            intArrayOf(1,1,1,0,1),
            intArrayOf(0,1,1,1,1),
            intArrayOf(1,1,1,0,1)
    )))
    assertEquals(9, largest1BorderedSquare(arrayOf(
            intArrayOf(1, 1, 1),
            intArrayOf(1, 0, 1),
            intArrayOf(1, 1, 1)
    )))
    assertEquals(4, largest1BorderedSquare(arrayOf(
            intArrayOf(1, 0, 1, 1),
            intArrayOf(1, 0, 1, 1),
            intArrayOf(1, 1, 1, 1)
    )))
    assertEquals(1, largest1BorderedSquare(arrayOf(
            intArrayOf(1, 1, 0, 0)
    )))
    assertEquals(0, largest1BorderedSquare(arrayOf()))
    assertEquals(0, largest1BorderedSquare(arrayOf(intArrayOf())))
    assertEquals(0, largest1BorderedSquare(arrayOf(intArrayOf(0))))
    assertEquals(0, largest1BorderedSquare(arrayOf(intArrayOf(0, 0))))
    assertEquals(0, largest1BorderedSquare(arrayOf(
            intArrayOf(0, 0),
            intArrayOf(0, 0)
    )))
}

fun largest1BorderedSquare(grid: Array<IntArray>): Int {
    var result = 0
    for (row in 0 until grid.size) {
        for (column in 0 until grid[row].size) {
            if (grid[row][column] == 1) {
                checkSquare(row, column, grid).let {
                    if (it > result) {
                        result = it
                    }
                }
            }
        }
    }
    return result
}

private fun checkSquare(row: Int, column: Int, grid: Array<IntArray>): Int {
    var topEdge = 1
    var tmp = column + 1
    while (tmp < grid[row].size && grid[row][tmp] == 1) {
        tmp++
        topEdge++
    }
    if (topEdge == 1) {
        return 1
    }
    for (edge in topEdge downTo 1) {
        if (isSquare(row, column, edge, grid)) {
            return edge * edge
        }
    }
    return 1
}

private fun isSquare(topRow: Int, leftColumn: Int, edge: Int, grid: Array<IntArray>): Boolean {
    val bottomRow = topRow + edge - 1
    val rightColumn = leftColumn + edge - 1
    for (row in topRow..bottomRow) {
        if (row >= grid.size) {
            return false
        }
        if (grid[row].size <= rightColumn) {
            return false
        }
        if (grid[row][leftColumn] == 0) {
            return false
        }
        if (grid[row][rightColumn] == 0) {
            return false
        }
    }
    for (column in leftColumn..rightColumn) {
        if (grid[bottomRow][column] == 0) {
            return false
        }
    }
    return true
}