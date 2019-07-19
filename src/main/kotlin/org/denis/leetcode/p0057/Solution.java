package org.denis.leetcode.p0057;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        int[][] result = new Solution().insert(new int[][]{
                {1, 3},
                {6, 9}
        }, new int[]{2, 5});
        List<int[]> list = Arrays.asList(result);
        for (int[] ints : list) {
            System.out.print(Arrays.toString(ints));
            System.out.print(", ");
        }
    }

    public static final Comparator<int[]> COMPARATOR = new Comparator<int[]>() {
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
    };

    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>(Arrays.asList(intervals));
        int j = Collections.binarySearch(result, newInterval, COMPARATOR);
        if (j < 0) {
            j = -j - 1;
        }
        result.add(j, newInterval);
        result = merge(result);

        int[][] r = new int[result.size()][];
        for (int i = 0; i < r.length; i++) {
            r[i] = result.get(i);
        }
        return r;
    }

    public List<int[]> merge(List<int[]> intervals) {
        if (intervals.size() == 0) {
            return intervals;
        }

        List<int[]> result = new ArrayList<>();
        int[] current = null;
        for (int i = 0; i < intervals.size(); i++) {
            if (intervals.get(i).length == 0) {
                continue;
            }
            if (current == null) {
                current = intervals.get(i);
                continue;
            }
            if (intervals.get(i)[0] <= current[1]) {
                current[1] = Math.max(current[1], intervals.get(i)[1]);
                continue;
            }
            result.add(current);
            current = intervals.get(i);
        }
        if (current != null) {
            result.add(current);
        }
        return result;
    }
}
