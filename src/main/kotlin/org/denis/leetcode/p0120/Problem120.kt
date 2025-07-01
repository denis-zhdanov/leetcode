package org.denis.leetcode.p0120

import org.junit.Assert.assertEquals

fun main() {
    val solution = Solution()
    assertEquals(11, solution.minimumTotal(listOf(listOf(2), listOf(3, 4), listOf(6, 5, 7), listOf(4, 1, 8, 3))))
}

class Solution {
    fun minimumTotal(triangle: List<List<Int>>): Int {
        if (triangle.isEmpty()) {
            return 0
        }
        var currentRow = mutableListOf<Int>()
        var previousRow = triangle.last().toMutableList()
        var tmp: MutableList<Int>
        for (row in triangle.size - 2 downTo 0) {
            for (column in 0..<triangle[row].size) {
                currentRow += triangle[row][column] + kotlin.math.min(previousRow[column], previousRow[column + 1])
            }
            previousRow.clear()
            tmp = previousRow
            previousRow = currentRow
            currentRow = tmp
        }
        return previousRow.first()
    }
}
