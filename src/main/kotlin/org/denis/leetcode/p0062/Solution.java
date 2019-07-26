package org.denis.leetcode.p0062;

public class Solution {
    public int uniquePaths(int m, int n) {
        if (m == 0 && n == 0) {
            return 1;
        }
        int[][] dp = new int[m][n];
        dp[0][0] = 1;
        return solve(dp, m - 1, n - 1);
    }

    private int solve(int[][] dp, int row, int column) {
        if (dp[row][column] > 0) {
            return dp[row][column];
        }
        int result = 0;
        if (row > 0) {
            result += solve(dp, row - 1, column);
        }
        if (column > 0) {
            result += solve(dp, row, column - 1);
        }
        dp[row][column] = result;
        return result;
    }
}
