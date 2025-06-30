package org.denis.leetcode.p0118

import kotlin.test.assertEquals

fun main() {
    val solution = Solution()
    assertEquals(listOf(listOf(1), listOf(1, 1), listOf(1, 2, 1), listOf(1, 3, 3, 1), listOf(1, 4, 6, 4, 1)), solution.generate(5))
}

class Solution {
    fun generate(numRows: Int): List<List<Int>> {
        val result = mutableListOf<MutableList<Int>>()
        for (row in 0..<numRows) {
            val rowData = mutableListOf<Int>()
            result += rowData
            rowData += 1
            if (row == 0) {
                continue
            }
            for (i in 0..(result[row - 1].size - 2)) {
                rowData += result[row - 1][i] + result[row - 1][i + 1]
            }
            rowData += 1
        }
        return result
    }
}
