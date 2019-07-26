package org.denis.leetcode.p0066;

public class Solution {
    public int[] plusOne(int[] digits) {
        if (digits.length == 0) {
            return new int[] {1};
        }
        boolean add = true;
        for (int i = digits.length - 1; add && i >= 0; i--) {
            int sum = digits[i] + 1;
            if (sum >= 10) {
                digits[i] = sum % 10;
            } else {
                digits[i] = sum;
                add = false;
            }
        }
        if (add) {
            int[] result = new int[digits.length + 1];
            System.arraycopy(digits, 0, result, 1, digits.length);
            result[0] = 1;
            return result;
        }
        return digits;
    }
}
