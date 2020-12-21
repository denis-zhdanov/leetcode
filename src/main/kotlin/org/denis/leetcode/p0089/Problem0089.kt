package org.denis.leetcode.p0089

import kotlin.test.assertEquals

fun main() {
    assertEquals(listOf(0, 1, 3, 2), Solution().grayCode(2))
    Solution().grayCode(3).forEach {
        println(it.toString(2).padStart(3, '0'))
    }
}

class Solution {
    fun grayCode(n: Int): List<Int> {
        if (n == 0) {
            return listOf(0)
        }
        val l = grayCode(n - 1)
        val base = 1 shl (n - 1)
        return l + l.reversed().map { it + base }
    }
}