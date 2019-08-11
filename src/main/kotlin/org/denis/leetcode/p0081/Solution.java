package org.denis.leetcode.p0081;

import static org.assertj.core.api.Assertions.assertThat;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        assertThat(solution.search(new int[]{15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14}, 25)).isTrue();
        assertThat(solution.search(new int[]{0, 0, 1, 1, 2, 3}, 3)).isTrue();
        assertThat(solution.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0)).isTrue();
        assertThat(solution.search(new int[]{1, 3, 1, 1, 1}, 3)).isTrue();
        assertThat(solution.search(new int[]{3, 1}, 1)).isTrue();
        assertThat(solution.search(new int[]{1, 3}, 3)).isTrue();
        assertThat(solution.search(new int[]{1, 3}, 0)).isFalse();
        assertThat(solution.search(new int[]{2, 5, 6, 0, 0, 1, 2}, 2)).isTrue();
        assertThat(solution.search(new int[]{2, 5, 6, 0, 0, 1, 2}, 5)).isTrue();
        assertThat(solution.search(new int[]{2, 5, 6, 0, 0, 1, 2}, 6)).isTrue();
        assertThat(solution.search(new int[]{2, 5, 6, 0, 0, 1, 2}, 0)).isTrue();
        assertThat(solution.search(new int[]{2, 5, 6, 0, 0, 1, 2}, 1)).isTrue();
        assertThat(solution.search(new int[]{2, 5, 6, 0, 0, 1, 2}, 2)).isTrue();
        assertThat(solution.search(new int[]{2, 5, 6, 0, 0, 1, 2}, 4)).isFalse();
        assertThat(solution.search(new int[]{2, 5, 6, 0, 0, 1, 2}, 3)).isFalse();
    }

    public boolean search(int[] nums, int target) {
        if (nums.length == 0) {
            return false;
        } else if (nums.length == 1) {
            return nums[0] == target;
        } else if (nums.length == 2) {
            return nums[0] == target || nums[1] == target;
        }
        int left = 0;
        int right = nums.length - 1;
        int rightPartStart = -1;
        while (left <= right) {
            left = shift(nums, left, 1, right);
            right = shift(nums, right, -1, left);
            if (left > right) {
                break;
            }
            int i = left + (right - left) / 2;
            if (nums[i] == target) {
                return true;
            } else if (nums[i] > nums[0]) {
                left = i + 1;
            } else {
                if (i == left) {
                    break;
                }
                rightPartStart = right;
                right = i;
            }
        }

        if (rightPartStart > 0 && nums[rightPartStart] >= nums[0]) {
            rightPartStart = -1;
        }

        if (rightPartStart < 0) {
            left = 0;
            right = nums.length - 1;
        } else {
            if (target < nums[0]) {
                left = rightPartStart;
                right = nums.length - 1;
            } else {
                left = 0;
                right = rightPartStart - 1;
            }
        }
        while (left <= right) {
            int i = left + (right - left) / 2;
            if (nums[i] == target) {
                return true;
            } else if (nums[i] < target) {
                left = i + 1;
            } else {
                right = i - 1;
            }
        }
        return false;
    }

    private int shift(int[] nums, int base, int step, int limit) {
        for (int i = base + step; i != limit && i >= 0 && i < nums.length; i += step) {
            if (nums[i] != nums[base]) {
                return i - step;
            }
        }
        return base;
    }
}
