package org.denis.leetcode.p0123

import kotlin.test.assertEquals

fun main() {
    val solution = Solution()
    assertEquals(6, solution.maxProfit(intArrayOf(3, 3, 5, 0, 0, 3, 1, 4)))
}

class Solution {
    fun maxProfit(prices: IntArray): Int {
        if (prices.isEmpty()) {
            return 0
        }

        var buy1 = Int.MIN_VALUE
        var sell1 = 0
        var buy2 = Int.MIN_VALUE
        var sell2 = 0

        for (price in prices) {
            buy1 = maxOf(buy1, -price)
            sell1 = maxOf(sell1, buy1 + price)
            buy2 = maxOf(buy2, sell1 - price)
            sell2 = maxOf(sell2, buy2 + price)
        }

        return sell2
    }
}
