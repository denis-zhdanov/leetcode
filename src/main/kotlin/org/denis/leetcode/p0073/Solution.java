package org.denis.leetcode.p0073;

public class Solution {
    public void setZeroes(int[][] matrix) {
        boolean firstRowContainsZero = false;
        for (int i = 0; i < matrix[0].length; i++) {
            if (matrix[0][i] == 0) {
                firstRowContainsZero = true;
                break;
            }
        }

        boolean firstColumnContainsZero = false;
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                firstColumnContainsZero = true;
                break;
            }
        }

        for (int row = 1; row < matrix.length; row++) {
            for (int column = 1; column < matrix[row].length; column++) {
                if (matrix[row][column] == 0) {
                    matrix[0][column] = 0;
                    matrix[row][0] = 0;
                }
            }
        }

        for (int row = 1; row < matrix.length; row++) {
            if (matrix[row][0] == 0) {
                for (int column = 1; column < matrix[row].length; column++) {
                    matrix[row][column] = 0;
                }
            }
        }

        for (int column = 1; column < matrix[0].length; column++) {
            if (matrix[0][column] == 0) {
                for (int row = 1; row < matrix.length; row++) {
                    matrix[row][column] = 0;
                }
            }
        }

        if (firstRowContainsZero) {
            for (int i = 0; i < matrix[0].length; i++) {
                matrix[0][i] = 0;
            }
        }

        if (firstColumnContainsZero) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}
