package org.denis.leetcode.p0128

import kotlin.math.max
import kotlin.test.assertEquals

fun main() {
    val solution = Solution()
    assertEquals(
        3,
        solution.longestConsecutive(intArrayOf(1,0,1,2))
    )

    assertEquals(
        9,
        solution.longestConsecutive(intArrayOf(0,3,7,2,5,8,4,6,0,1))
    )
    assertEquals(
        4,
        solution.longestConsecutive(intArrayOf(100,4,200,1,3,2))
    )
}

class Solution {
    fun longestConsecutive(nums: IntArray): Int {
        var result = 0
        val numsSet = nums.toSet()
        for (n in numsSet) {
            if (nums.contains(n - 1)) {
                continue
            }
            var candidate = 1
            var next = n + 1
            while (numsSet.contains(next)) {
                candidate++
                next++
            }
            result = max(result, candidate)
        }
        return result
    }
}