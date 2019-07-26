package org.denis.leetcode.p0064;

public class Solution {

    public int minPathSum(int[][] grid) {
        if (grid.length == 0) {
            return 0;
        }
        int rows = grid.length;
        int columns = grid[0].length;
        int[][] dp = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                dp[i][j] = -1;
            }
        }
        dp[0][0] = grid[0][0];
        return solve(dp, grid, rows - 1, columns - 1);
    }

    public int solve(int[][] dp, int[][] grid, int row, int column) {
        if (dp[row][column] >= 0) {
            return dp[row][column];
        }
        int previous = -1;
        if (row > 0) {
            previous = solve(dp, grid, row - 1, column);
        }
        if (column > 0) {
            if (previous < 0) {
                previous = solve(dp, grid, row, column - 1);
            } else {
                previous = Math.min(previous, solve(dp, grid, row, column - 1));
            }
        }
        dp[row][column] = grid[row][column] + previous;
        return dp[row][column];
    }
}
