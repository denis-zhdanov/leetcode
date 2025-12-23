package org.denis.leetcode.p0135

import kotlin.test.assertEquals

fun main() {
    val solution = Solution()
    assertEquals(
        4,
        solution.candy(intArrayOf(1,2,2))
    )
    assertEquals(
        5,
        solution.candy(intArrayOf(1,0,2))
    )
}

class Solution {
    fun candy(ratings: IntArray): Int {
        if (ratings.isEmpty()) {
            return 0
        }
        val candies = IntArray(ratings.size) { 1 }

        for (i in 1 until ratings.size) {
            if (ratings[i - 1] < ratings[i]) {
                candies[i] = candies[i - 1] + 1
            }
        }

        for (i in (ratings.size - 2) downTo 0) {
            if (ratings[i] > ratings[i + 1]) {
                candies[i] = maxOf(candies[i], candies[i + 1] + 1)
            }
        }

        return candies.sum()
    }
}