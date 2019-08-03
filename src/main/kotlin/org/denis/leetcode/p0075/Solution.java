package org.denis.leetcode.p0075;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        verify(new int[] {1, 2, 0}, 0, 1, 2);
        verify(new int[]{0, 0, 1, 0, 2}, 0, 0, 0, 1, 2);
        verify(new int[0]);
    }

    private static void verify(int[] input, int... expected) {
        new Solution().sortColors(input);
        for (int i = 0; i < input.length; i++) {
            if (input[i] != expected[i]) {
                throw new IllegalArgumentException(String.format(
                        "Mismatch at index %d - expected: %s, actual: %s%n",
                        i, Arrays.toString(expected), Arrays.toString(input)
                ));
            }
        }
    }

    public void sortColors(int[] nums) {
        int zeroIndex = 0;
        int twoIndex = nums.length - 1;
        for (int i = 0; i <= twoIndex; i++) {
            if (nums[i] == 0) {
                swap(nums, zeroIndex++, i);
            } else if (nums[i] == 2) {
                swap(nums, twoIndex--, i--);
            }
        }
    }

    private void swap(int[] data, int i, int j) {
        if (i == j) {
            return;
        }
        int tmp = data[i];
        data[i] = data[j];
        data[j] = tmp;
    }
}
