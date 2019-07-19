package org.denis.leetcode.p0051

import kotlin.test.fail

fun main() {
    verify(4, solveNQueens(4))
    verify(5, solveNQueens(5))
}

private fun verify(dimension: Int, solutions: List<List<String>>) {
    if (solutions.isEmpty()) {
        fail("No solution is found")
    }
    for (solution in solutions) {
        doVerify(dimension, solution)
    }
}

private fun doVerify(dimension: Int, solution: List<String>) {
    if (dimension != solution.size) {
        fail("Expected to find $dimension rows but got ${solution.size}")
    }
    val availablePoints = mutableSetOf<Point>()
    for (row in 0 until dimension) {
        for (column in 0 until dimension) {
            availablePoints += Point(row, column)
        }
    }

    var queensCount = 0
    solution.forEachIndexed { row, rowData ->
        rowData.forEachIndexed { column, symbol ->
            if (symbol == 'Q') {
                queensCount++
                val point = Point(row, column)
                if (!availablePoints.contains(point)) {
                    fail("Point $point is crossed by more than one queen")
                }
                withSelectedPoint(point, availablePoints, dimension)
            }
        }
    }
    if (queensCount != dimension) {
        fail("Expected to find $dimension queens but found $queensCount")
    }
    println()
    for (row in solution) {
        println(row)
    }
}

fun solveNQueens(n: Int): List<List<String>> {
    if (n == 1) {
        return listOf(listOf("Q"))
    }
    if (n < 4) {
        return emptyList()
    }
    val availablePoints = mutableSetOf<Point>()
    for (row in 0 until n) {
        for (column in 0 until n) {
            availablePoints += Point(row, column)
        }
    }
    val solutions = solve(n, 0, availablePoints) ?: return emptyList()
    val result = mutableListOf<List<String>>()
    for (solution in solutions) {
        val board = mutableListOf<String>()
        for (row in 0 until n) {
            val rowData = StringBuilder()
            for (column in 0 until n) {
                if (solution.contains(Point(row, column))) {
                    rowData.append("Q")
                } else {
                    rowData.append(".")
                }
            }
            board += rowData.toString()
        }
        result += board
    }
    return result
}

private fun solve(n: Int, row: Int, availablePoints: Set<Point>): Set<Set<Point>>? {
    if (availablePoints.isEmpty()) {
        return if (row >= n) {
            emptySet()
        } else {
            null
        }
    }
    if (row >= n) {
        return null
    }

    val result = mutableSetOf<Set<Point>>()
    for (column in 0 until n) {
        val point = Point(row, column)
        if (availablePoints.contains(point)) {
            solve(n, row + 1, availablePoints.toMutableSet().apply {
                withSelectedPoint(point, this, n)
            })?.let { subSolutions ->
                if (subSolutions.isEmpty()) {
                    result += setOf(point)
                } else {
                    for (subSolution in subSolutions) {
                        result += subSolution + point
                    }
                }
            }
        }
    }
    return result.takeIf { it.isNotEmpty() }
}

private fun withSelectedPoint(point: Point, points: MutableSet<Point>, dimension: Int) {
    for (column in 0 until dimension) {
        points -= Point(point.row, column)
    }
    for (row in 0 until dimension) {
        points -= Point(row, point.column)
    }
    removeDiagonal(point, points, 1, 1, dimension)
    removeDiagonal(point, points, 1, -1, dimension)
    removeDiagonal(point, points, -1, -1, dimension)
    removeDiagonal(point, points, -1, 1, dimension)
}

private fun removeDiagonal(seed: Point, points: MutableSet<Point>, columnShift: Int, rowShift: Int, dimension: Int) {
    var row = seed.row + rowShift
    var column = seed.column + columnShift
    while (row in 0..(dimension - 1) && column in 0..(dimension - 1)) {
        points -= Point(row, column)
        row += rowShift
        column += columnShift
    }
}

data class Point(val row: Int, val column: Int)