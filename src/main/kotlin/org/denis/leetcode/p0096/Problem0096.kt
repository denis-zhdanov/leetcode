package org.denis.leetcode.p0096

import kotlin.test.assertEquals

fun main() {
    assertEquals(5, Solution().numTrees(3))
    assertEquals(1, Solution().numTrees(1))
    assertEquals(1767263190, Solution().numTrees(19))
}

class Solution {
    fun numTrees(n: Int): Int {
        return if (n <= 0) {
            0
        } else {
            solve(1, n)
        }
    }

    private fun solve(left: Int, right: Int): Int {
        if (left > right) {
            return 1
        }

        return (left..right).sumBy {
            solve(left, it - 1) * solve(it + 1, right)
        }
    }
}