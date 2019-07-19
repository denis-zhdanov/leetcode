package org.denis.leetcode.p0055;

public class Solution {

    public boolean canJump(int[] nums) {
        if (nums.length == 0) {
            return true;
        }
        nums[nums.length - 1] = -1;
        for (int i = nums.length - 2; i >= 0; i--) {
            for (int j = i + nums[i]; j > i; j--) {
                if (j >= nums.length || nums[j] < 0) {
                    nums[i] = -1;
                    break;
                }
            }
        }
        return nums[0] < 0;
    }
}
