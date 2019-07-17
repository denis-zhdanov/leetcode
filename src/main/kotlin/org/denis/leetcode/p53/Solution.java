package org.denis.leetcode.p53;

public class Solution {
    public int maxSubArray(int[] nums) {
        int result = Integer.MIN_VALUE;
        int candidate = Integer.MIN_VALUE;
        int i = 0;
        for (; i < nums.length; i++) {
            if (result < nums[i]) {
                result = nums[i];
            }
            if (nums[i] > 0) {
                candidate = nums[i];
                i++;
                break;
            }
        }
        for (; i < nums.length; i++) {
            candidate += nums[i];
            if (candidate > result) {
                result = candidate;
            }
            if (candidate < 0) {
                candidate = 0;
            }
        }
        return result;
    }
}
