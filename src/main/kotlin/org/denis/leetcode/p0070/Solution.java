package org.denis.leetcode.p0070;

public class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        if (n > 1) {
            dp[1] = 1;
        }
        for (int i = 0; i < n; i++) {
            if (i + 1 < n) {
                dp[i + 1] += dp[i];
            }
            if (i + 2 < n) {
                dp[i + 2] += dp[i];
            }
        }
        return dp[n - 1];
    }
}
