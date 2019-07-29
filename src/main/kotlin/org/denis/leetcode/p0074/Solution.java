package org.denis.leetcode.p0074;

public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int left = 0;
        int right = matrix.length * matrix[0].length - 1;
        while (left <= right) {
            int midIndex = left + (right - left) / 2;
            int row = midIndex / matrix[0].length;
            int column = midIndex % matrix[0].length;
            int midValue = matrix[row][column];
            if (midValue == target) {
                return true;
            } else if (midValue < target) {
                left = midIndex + 1;
            } else {
                right = midIndex - 1;
            }
        }
        return false;
    }
}
