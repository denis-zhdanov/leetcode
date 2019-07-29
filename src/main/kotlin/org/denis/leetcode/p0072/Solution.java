package org.denis.leetcode.p0072;

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().minDistance("sea", "eat"));
        System.out.println(new Solution().minDistance("horse", "ros"));
        System.out.println(new Solution().minDistance("intention", "execution"));
    }

    public int minDistance(String word1, String word2) {
        Integer[][] dp = buildDp(word1.length() + 1, word2.length() + 1);
        return solve(word1, word1.length(), word2, word2.length(), dp);
    }

    private Integer[][] buildDp(int l1, int l2) {
        Integer[][] result = new Integer[l1][l2];
        for (int i = 1; i < l1; i++) {
            result[i][0] = i;
        }
        for (int i = 1; i < l2; i++) {
            result[0][i] = i;
        }
        result[0][0] = 0;
        return result;
    }

    private int solve(String word1, int l1, String word2, int l2, Integer[][] dp) {
        if (dp[l1][l2] != null) {
            return dp[l1][l2];
        }
        if (word1.charAt(l1 - 1) == word2.charAt(l2 - 1)) {
            dp[l1][l2] = solve(word1, l1 - 1, word2, l2 - 1, dp);
        } else {
            dp[l1][l2] = 1 + min(solve(word1, l1 - 1, word2, l2, dp),
                                 solve(word1, l1, word2, l2 - 1, dp),
                                 solve(word1, l1 - 1, word2, l2 - 1, dp));
        }
        return dp[l1][l2];
    }

    private int min(int ... values) {
        int result = values[0];
        for (int i = 1; i < values.length; i++) {
            if (values[i] < result) {
                result = values[i];
            }
        }
        return result;
    }
}
