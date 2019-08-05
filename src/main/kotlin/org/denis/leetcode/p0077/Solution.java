package org.denis.leetcode.p0077;

import java.util.*;

public class Solution {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        solve(1, n, k, current, result);
        return result;
    }

    private void solve(int start, int n, int k, List<Integer> current, List<List<Integer>> result) {
        if (k == 0) {
            result.add(new ArrayList<>(current));
            return;
        }
        for (int i = start; i <= n - k + 1; i++) {
            current.add(i);
            solve(i + 1, n, k - 1, current, result);
            current.remove((Integer)i);
        }
    }
}
