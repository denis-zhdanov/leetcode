package org.denis.leetcode.p0067;

public class Solution {

    public String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();
        int increment = 0;
        for (int i = 1, max = Math.max(a.length(), b.length()); i <= max; i++) {
            int aI = a.length() - i;
            boolean aOne = aI >= 0 && a.charAt(aI) == '1';
            int bI = b.length() - i;
            boolean bOne = bI >= 0 && b.charAt(bI) == '1';
            final char toAdd;
            if (aOne && bOne) {
                if (increment > 0) {
                    toAdd = '1';
                } else {
                    toAdd = '0';
                    increment++;
                }
            } else if (aOne ^ bOne) {
                if (increment > 0) {
                    toAdd = '0';
                } else {
                    toAdd = '1';
                }
            } else {
                if (increment > 0) {
                    toAdd = '1';
                    increment--;
                } else {
                    toAdd = '0';
                }
            }
            result.insert(0, toAdd);
        }
        while (increment-- > 0) {
            result.insert(0, '1');
        }
        if (result.length() == 0) {
            return "0";
        }
        return result.toString();
    }
}
