package org.denis.leetcode.p0122

import kotlin.test.assertEquals

fun main() {
    val solution = Solution()
    assertEquals(7, solution.maxProfit(intArrayOf(7, 1, 5, 3, 6, 4)))
    assertEquals(2, solution.maxProfit(intArrayOf(1, 2, 3)))
}

class Solution {
    fun maxProfit(prices: IntArray): Int {
        var result = 0
        for (i in 1 until prices.size) {
            val diff = prices[i] - prices[i - 1]
            if (diff > 0) {
                result += diff
            }
        }
        return result
    }
}
