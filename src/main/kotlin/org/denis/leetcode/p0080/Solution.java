package org.denis.leetcode.p0080;

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().removeDuplicates(new int[]{1, 1, 1, 2, 2, 2, 3, 3}));
    }

    public int removeDuplicates(int[] nums) {
        if (nums.length <= 2) {
            return nums.length;
        }
        int tail = 1;
        int lastNumber = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != lastNumber) {
                lastNumber = nums[i];
                count = 1;
                if (tail != i) {
                    nums[tail++] = nums[i];
                } else {
                    tail++;
                }
                continue;
            }
            if (count < 2) {
                count++;
                if (tail != i) {
                    nums[tail++] = nums[i];
                } else {
                    tail++;
                }
            }
        }
        return tail;
    }
}
