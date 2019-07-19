package org.denis.leetcode.p0056;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution {

    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return intervals;
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] a1, int[] a2) {
                if (a1.length == 0) {
                    return a2.length == 0 ? 0 : -1;
                }
                if (a2.length == 0) {
                    return 1;
                }
                if (a1[0] < a2[0]) {
                    return -1;
                } else if (a1[0] > a2[0]) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });

        List<int[]> result = new ArrayList<>();
        int[] current = null;
        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i].length == 0) {
                continue;
            }
            if (current == null) {
                current = intervals[i];
                continue;
            }
            if (intervals[i][0] <= current[1]) {
                current[1] = Math.max(current[1], intervals[i][1]);
                continue;
            }
            result.add(current);
            current = intervals[i];
        }
        if (current != null) {
            result.add(current);
        }
        int[][] r = new int[result.size()][];
        for (int i = 0; i < r.length; i++) {
            r[i] = result.get(i);
        }
        return r;
    }
}
