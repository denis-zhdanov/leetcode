package org.denis.leetcode.p0091

import kotlin.test.assertEquals

fun main() {
    assertEquals(1836311903, Solution().numDecodings("111111111111111111111111111111111111111111111"))
    assertEquals(2, Solution().numDecodings("12"))
    assertEquals(3, Solution().numDecodings("226"))
    assertEquals(0, Solution().numDecodings("0"))
}

class Solution {
    fun numDecodings(s: String): Int {
        return num(s, mutableMapOf()) ?: 0
    }

    private fun num(s: String, cache: MutableMap<String, Int?>): Int? {
        cache[s]?.let {
            return it
        }
        if (s.isEmpty()) {
            return 1
        }
        if (s.first() == '0') {
            return null
        }
        val s1 = s.substring(1)
        val c1 = num(s1, cache)
        cache[s1] = c1
        if (s.length > 1) {
            if (s.first() == '1' || (s.first() == '2' && s[1] >= '0' && s[1] <= '6')) {
                val s2 = s.substring(2)
                val c2 = num(s2, cache)
                cache[s2] = c2
                return when {
                    c1 == null && c2 == null -> null
                    c1 == null -> c2
                    c2 == null -> c1
                    else -> c1 + c2
                }
            }
        }
        return c1
    }
}