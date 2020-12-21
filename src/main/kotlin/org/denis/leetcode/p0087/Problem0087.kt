package org.denis.leetcode.p0087

import kotlin.test.assertFalse
import kotlin.test.assertTrue

fun main() {
    assertFalse(Solution().isScramble("abcdefghijklmnopq", "efghijklmnopqcadb"))
    assertFalse(Solution().isScramble("phlvandlvyupcq", "paplyvvdhnulcq"))
    assertTrue(Solution().isScramble("abb", "bba"))
    assertTrue(Solution().isScramble("abb", "bab"))
    assertTrue(Solution().isScramble("a", "a"))
    assertFalse(Solution().isScramble("abcde", "caebd"))
    assertTrue(Solution().isScramble("great", "rgeat"))
}

class Solution {
    fun isScramble(s1: String, s2: String): Boolean {
        if (s1.length != s2.length) {
            return false
        }
        return isScramble(s1, s2, mutableMapOf())
    }

    private fun isScramble(s1: String, s2: String, cache: MutableMap<Set<String>, Boolean>): Boolean {
        val key = setOf(s1, s2)
        cache[key]?.let {
            return it
        }

        if (s1 == s2) {
            cache[key] = true
            return true
        }
        for (length in (1 until s1.length)) {
            val left = s1.substring(0, length)
            val right = s1.substring(length)

            if ((isScramble(left, s2.substring(0, length)) && isScramble(right, s2.substring(length)))
                || (isScramble(left, s2.substring(s2.length - left.length)) && isScramble(right, s2.substring(0, right.length)))
            ) {
                cache[key] = true
                return true
            }
        }
        cache[setOf(s1, s2)] = false
        return false
    }
}