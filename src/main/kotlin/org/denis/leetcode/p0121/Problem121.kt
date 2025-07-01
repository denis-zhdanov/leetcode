package org.denis.leetcode.p0121

import kotlin.test.assertEquals

fun main() {
    val solution = Solution()
    assertEquals(5, solution.maxProfit(intArrayOf(7, 1, 5, 3, 6, 4)))
    assertEquals(0, solution.maxProfit(intArrayOf(7, 6, 4, 3, 1)))
}

class Solution {
    fun maxProfit(prices: IntArray): Int {
        var min = Integer.MAX_VALUE
        var result = 0
        for (p in prices) {
            min = kotlin.math.min(min, p)
            result = kotlin.math.max(p - min, result)
        }
        return result
    }
}
