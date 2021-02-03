package org.denis.leetcode.p0097

import kotlin.test.assertTrue

fun main() {
    assertTrue(Solution().isInterleave("aabcc", "dbbca", "aadbbcbcac"))
}

class Solution {
    fun isInterleave(s1: String, s2: String, s3: String): Boolean {
        val l1 = s1.length
        val l2 = s2.length
        val l3 = s3.length
        if (l3 != l1 + l2) {
            return false
        }

        if (l1 == 0) {
            return s2 == s3
        }
        if (l2 == 0) {
            return s1 == s3
        }

        val dp = Array(l1 + 1) {
            BooleanArray(l2 + 1) { false }
        }
        dp[0][0] = true

        for (i in 0..l1) {
            for (j in 0..l2) {
                if (i > 0) {
                    dp[i][j] = s1[i - 1] == s3[i + j - 1] && dp[i - 1][j]
                }
                if (j > 0) {
                    dp[i][j] = dp[i][j] || s2[j - 1] == s3[i + j - 1] && dp[i][j - 1]
                }
            }
        }
        return dp[l1][l2]
    }
}