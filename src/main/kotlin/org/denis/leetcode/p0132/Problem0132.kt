package org.denis.leetcode.p0132

import kotlin.math.min
import kotlin.test.assertEquals

fun main() {
    val solution = Solution()
    assertEquals(
        0,
        solution.minCut("ababababababababababababcbabababababababababababa")
    )
    assertEquals(
        1,
        solution.minCut("ab")
    )
    assertEquals(
        0,
        solution.minCut("a")
    )
    assertEquals(
        1,
        solution.minCut("aab")
    )
}

class Solution {
    fun minCut(s: String): Int {
        val n = s.length

        val palindromes = Array(n) { BooleanArray(n) { false } }
        for (i in n - 1 downTo 0) {
            for (j in i until n) {
                if (s[i] == s[j] && (j - i <= 2 || palindromes[i + 1][j - 1])) {
                    palindromes[i][j] = true
                }
            }
        }

        val dp = IntArray(n) { it }
        for (i in 0 until n) {
            if (palindromes[0][i]) {
                dp[i] = 0
            } else {
                for (j in 0 until i) {
                    if (palindromes[j + 1][i]) {
                        dp[i] = min(dp[i], dp[j] + 1)
                    }
                }
            }
        }
        return dp[n - 1]
    }
}