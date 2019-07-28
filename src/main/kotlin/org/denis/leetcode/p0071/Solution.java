package org.denis.leetcode.p0071;

import java.util.Stack;

public class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        int[] index = { 0 };
        while (true) {
            String dir = nextDir(path, index);
            if (dir == null) {
                break;
            }
            if (".".equals(dir)) {
                continue;
            }
            if ("..".equals(dir)) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
                continue;
            }
            stack.push(dir);
        }
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            if (result.length() > 0) {
                result.insert(0, "/");
            }
            result.insert(0, stack.pop());
        }
        result.insert(0, "/");
        return result.toString();
    }

    private String nextDir(String path, int[] index) {
        int start = index[0];
        for (; start < path.length(); start++) {
            if (path.charAt(start) != '/') {
                break;
            }
        }
        if (start >= path.length()) {
            return null;
        }
        int end = start + 1;
        for (; end < path.length(); end++) {
            if (path.charAt(end) == '/') {
                break;
            }
        }
        index[0] = end;
        return path.substring(start, end);
    }
}
