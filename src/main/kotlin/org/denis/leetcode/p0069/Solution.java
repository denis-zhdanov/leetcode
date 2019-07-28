package org.denis.leetcode.p0069;

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().mySqrt(2147395599));
    }

    public int mySqrt(int x) {
        if (x == 0 || x == 1) {
            return x;
        }
        int start = 2;
        int end = x / 2;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            int square = mid * mid;
            if (square / mid != mid) {
                end = mid - 1;
                continue;
            }
            if (square == x) {
                return mid;
            }
            if (square < x) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return start - 1;
    }
}
