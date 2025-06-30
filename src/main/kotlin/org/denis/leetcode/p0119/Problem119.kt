package org.denis.leetcode.p0119

import kotlin.test.assertEquals

fun main() {
    val solution = Solution()
    assertEquals(listOf(1, 3, 3, 1), solution.getRow(3))
    assertEquals(listOf(1), solution.getRow(0))
    assertEquals(listOf(1, 1), solution.getRow(1))
}

class Solution {
    fun getRow(rowIndex: Int): List<Int> {
        var row = 0
        var currentRow = mutableListOf(1)
        var nextRow = mutableListOf<Int>()
        var tmp: MutableList<Int>
        while (row++ < rowIndex) {
            nextRow += 1
            var i = 0
            while (i < currentRow.size - 1) {
                nextRow += currentRow[i] + currentRow[i + 1]
                i++
            }
            nextRow += 1
            currentRow.clear()
            tmp = currentRow
            currentRow = nextRow
            nextRow = tmp
        }
        return currentRow
    }
}
