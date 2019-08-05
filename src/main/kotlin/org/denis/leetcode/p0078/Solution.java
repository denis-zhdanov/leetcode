package org.denis.leetcode.p0078;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        if (nums.length == 0) {
            return Collections.emptyList();
        }
        List<List<Integer>> result = new ArrayList<>();
        result.add(Collections.emptyList());
        List<Integer> current = new ArrayList<>();
        solve(0, nums, result, current);
        return result;
    }

    private void solve(int start, int[] nums, List<List<Integer>> result, List<Integer> current) {
        for (int i = start; i < nums.length; i++) {
            current.add(nums[i]);
            result.add(new ArrayList<>(current));
            solve(i + 1, nums, result, current);
            current.remove((Integer)nums[i]);
        }
    }
}
