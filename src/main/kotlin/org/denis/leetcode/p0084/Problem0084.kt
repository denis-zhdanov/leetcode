package org.denis.leetcode.p0084

import java.util.*
import kotlin.math.max
import kotlin.math.min
import kotlin.test.assertEquals

fun main() {
    assertEquals(12, Solution().largestRectangleArea(intArrayOf(5, 5, 1, 7, 1, 1, 5, 2, 7, 6)))
    assertEquals(8, Solution().largestRectangleArea(intArrayOf(5, 4, 1, 2)))
    assertEquals(3, Solution().largestRectangleArea(intArrayOf(2, 1, 2)))
    assertEquals(4, Solution().largestRectangleArea(intArrayOf(1, 2, 2)))
    assertEquals(9, Solution().largestRectangleArea(intArrayOf(0, 9)))
    assertEquals(4, Solution().largestRectangleArea(intArrayOf(4, 2)))
    assertEquals(10, Solution().largestRectangleArea(intArrayOf(2, 1, 5, 6, 2, 3)))
}

class Solution {

    fun largestRectangleArea(heights: IntArray): Int {
        return split(heights).map(this::doLargestRectangleArea).max() ?: 0
    }

    private fun doLargestRectangleArea(heights: IntArray): Int {
        if (heights.isEmpty()) {
            return 0
        }
        val indexes = Stack<Int>()
        var result = 0
        var minHeight = Int.MAX_VALUE
        heights.forEachIndexed { index, height ->
            while (indexes.isNotEmpty() && heights[indexes.peek()] > height) {
                val i = indexes.pop()
                val j = if (indexes.isEmpty()) {
                    -1
                } else {
                    indexes.peek()
                }
                result = max(result, heights[i] * (index - j - 1))
            }
            indexes += index
            minHeight = min(height, minHeight)
        }

        while (indexes.isNotEmpty()) {
            val i = indexes.pop()
            if (indexes.isEmpty()) {
                result = max(result, heights[i] * heights.size)
            } else {
                result = max(result, heights[i] * (heights.size - indexes.peek() - 1))
            }
        }
        return result
    }

    private fun split(heights: IntArray): Collection<IntArray> {
        val result = mutableListOf<IntArray>()
        var start = 0
        heights.forEachIndexed { index, height ->
            if (height == 0) {
                if (index > start) {
                    result += heights.copyOfRange(start, index)
                }
                start = index + 1
            }
        }
        if (start < heights.size) {
            result += heights.copyOfRange(start, heights.size)
        }
        return result
    }
}