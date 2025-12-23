package org.denis.leetcode.p0134

import kotlin.test.assertEquals

fun main() {
    val solution = Solution()
    assertEquals(
        -1,
        solution.canCompleteCircuit(intArrayOf(2,3,4), intArrayOf(3,4,3))
    )
    assertEquals(
        3,
        solution.canCompleteCircuit(intArrayOf(1,2,3,4,5), intArrayOf(3,4,5,1,2))
    )
}

class Solution {
    fun canCompleteCircuit(gas: IntArray, cost: IntArray): Int {
        var totalTank = 0
        var currTank = 0
        var start = 0

        for (i in gas.indices) {
            val diff = gas[i] - cost[i]
            totalTank += diff
            currTank += diff

            // Can't reach next station
            if (currTank < 0) {
                start = i + 1
                currTank = 0
            }
        }

        return if (totalTank >= 0) {
            start
        } else {
            -1
        }
    }
}