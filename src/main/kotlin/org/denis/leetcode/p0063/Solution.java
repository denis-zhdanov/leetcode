package org.denis.leetcode.p0063;

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().uniquePathsWithObstacles(new int[][] {
                {0, 0}
        }));
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid[0][0] > 0) {
            return 0;
        }
        int m = obstacleGrid.length - 1;
        int n = obstacleGrid[0].length - 1;
        if (obstacleGrid[m][n] > 0) {
            return 0;
        }
        Integer[][] dp = new Integer[m + 1][n + 1];
        dp[0][0] = 1;
        return solve(obstacleGrid, dp, m, n);
    }

    private int solve(int[][] obstacles, Integer[][] dp, int row, int column) {
        if (dp[row][column] != null) {
            return dp[row][column];
        }
        int result = 0;
        if (row > 0 && obstacles[row - 1][column] <= 0) {
            result += solve(obstacles, dp, row - 1, column);
        }
        if (column > 0 && obstacles[row][column - 1] <= 0) {
            result += solve(obstacles, dp, row, column - 1);
        }
        dp[row][column] = result;
        return result;
    }
}
