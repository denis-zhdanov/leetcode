package org.denis.leetcode.p0060;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().getPermutation(3, 4));
    }

    public String getPermutation(int n, int k) {
        StringBuilder result = new StringBuilder();
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        int tmp = factorial(n);
        int rem = k - 1;
        for (int i = 0; i < n; i++) {
            int permutationsNumber = tmp / list.size();
            tmp /= list.size();
            result.append(list.remove(rem / permutationsNumber));
            rem %= permutationsNumber;
        }
        return result.toString();
    }

    private int factorial(int n) {
        if (n <= 1) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }
}
