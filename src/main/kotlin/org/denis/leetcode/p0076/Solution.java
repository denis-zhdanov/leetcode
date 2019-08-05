package org.denis.leetcode.p0076;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().minWindow("ADOBECODEBANC", "ABC"));
        System.out.println(new Solution().minWindow("ADOBECODEBANC", "ABZ"));
    }

    public String minWindow(String s, String t) {
        Context context = new Context(buildMissing(t), s);
        while (findWindow(context)) {
            char c = s.charAt(context.start);
            context.current.put(c, context.current.get(c) - 1);
            context.missing.put(c, context.missing.get(c) + 1);
            context.start++;
            context.end++;
        }
        return context.result;
    }

    private Map<Character, Integer> buildMissing(String s) {
        Map<Character, Integer> result = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            Integer count = result.get(c);
            if (count == null) {
                count = 0;
            }
            result.put(c, count + 1);
        }
        return result;
    }

    private boolean findWindow(Context context) {
        if (!findWindowEnd(context)) {
            return false;
        }
        trimWindowStart(context);
        return true;
    }

    private boolean findWindowEnd(Context context) {
        while (context.end < context.s.length()) {
            char c = context.s.charAt(context.end);
            Integer missingCount = context.missing.get(c);
            if (missingCount != null && missingCount > 0) {
                context.missing.put(c, missingCount - 1);
            }
            Integer currentCount = context.current.get(c);
            if (currentCount == null) {
                currentCount = 0;
            }
            context.current.put(c, currentCount + 1);
            if (isMatch(context)) {
                return true;
            } else {
                context.end++;
            }
        }
        return false;
    }

    private void trimWindowStart(Context context) {
        while (context.start < context.s.length()) {
            char c = context.s.charAt(context.start);
            Integer allMissingCount = context.allMissing.get(c);
            if (allMissingCount == null) {
                context.start++;
                continue;
            }
            Integer currentCount = context.current.get(c);
            if (currentCount > allMissingCount) {
                context.current.put(c, currentCount - 1);
                context.start++;
                continue;
            }
            if ("".equals(context.result) || context.end - context.start + 1 < context.result.length()) {
                context.result = context.s.substring(context.start, context.end + 1);
            }
            return;
        }
    }

    private boolean isMatch(Context context) {
        for (Integer missingCount : context.missing.values()) {
            if (missingCount > 0) {
                return false;
            }
        }
        return true;
    }

    private static class Context {
        public final Map<Character, Integer> missing    = new HashMap<>();
        public final Map<Character, Integer> allMissing = new HashMap<>();
        public final Map<Character, Integer> current    = new HashMap<>();
        public final String                  s;
        public       String                  result     = "";
        int start;
        int end;

        public Context(Map<Character, Integer> missing, String s) {
            this.missing.putAll(missing);
            allMissing.putAll(missing);
            this.s = s;
        }
    }
}
