package org.denis.leetcode.p0115

import kotlin.test.assertEquals

fun main() {
    val solution = Solution()
    assertEquals(700531452, solution.numDistinct("adbdadeecadeadeccaeaabdabdbcdabddddabcaaadbabaaedeeddeaeebcdeabcaaaeeaeeabcddcebddebeebedaecccbdcbcedbdaeaedcdebeecdaaedaacadbdccabddaddacdddc", "bcddceeeebecbc"))
    assertEquals(3, solution.numDistinct("rabbbit", "rabbit"))
    assertEquals(5, solution.numDistinct("babgbag", "bag"))
}

class Solution {
    fun numDistinct(s: String, t: String): Int {
        val dp = Array(t.length + 1) { IntArray(s.length + 1) }
        for (j in 0..s.length) {
            dp[0][j] = 1 // Empty t can be formed from any prefix of s
        }
        for (i in 1..t.length) {
            for (j in 1..s.length) {
                if (t[i - 1] == s[j - 1]) {
                    dp[i][j] = dp[i][j - 1] + dp[i - 1][j - 1]
                } else {
                    dp[i][j] = dp[i][j - 1]
                }
            }
        }
        return dp[t.length][s.length]
    }
}
