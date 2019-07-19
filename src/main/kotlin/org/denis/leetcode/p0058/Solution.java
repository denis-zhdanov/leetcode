package org.denis.leetcode.p0058;

public class Solution {

    public int lengthOfLastWord(String s) {
        int result = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c == ' ') {
                if (result > 0) {
                    return result;
                }
            } else {
                result++;
            }
        }
        return result;
    }
}
