package org.denis.leetcode.p0065;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        Map<String, Boolean> expectations = new HashMap<>();
        expectations.put("0", true);
        expectations.put("  0.1", true);
        expectations.put("abc", false);
        expectations.put("1 a", false);
        expectations.put("2e10", true);
        expectations.put(" -90e3   ", true);
        expectations.put(" 1e", false);
        expectations.put("e3", false);
        expectations.put(" 6e-1", true);
        expectations.put(" 99e2.5 ", false);
        expectations.put("53.5e93", true);
        expectations.put(" --6 ", false);
        expectations.put("-+3", false);
        expectations.put("95a54e53", false);
        expectations.put("-5e-1", true);
        expectations.put("-5e+1", true);
        expectations.put("+5e-1", true);
        expectations.put("+5e+1", true);
        expectations.put(".1", true);
        expectations.put(".5e-1", true);
        expectations.put(".e-1", false);
        expectations.put("-.3e-1", true);
        expectations.put("3.", true);
        expectations.put(".", false);
        expectations.put("46.e3", true);
        for (Map.Entry<String, Boolean> entry : expectations.entrySet()) {
            if (solution.isNumber(entry.getKey()) != entry.getValue()) {
                System.out.printf("Failure for input '%s' - expected %b%n", entry.getKey(), entry.getValue());
            }
        }
    }

    public boolean isNumber(String s) {
        for (Pattern p : PATTERNS) {
            if (p.matcher(s).matches()) {
                return true;
            }
        }
        return false;
    }

    private static Collection<Pattern> PATTERNS = Arrays.asList(
            Pattern.compile("\\s*[-+]?\\d+\\s*"),
            Pattern.compile("\\s*[-+]?\\d+\\.\\d*\\s*"),
            Pattern.compile("\\s*[-+]?\\d*\\.\\d+\\s*"),
            Pattern.compile("\\s*[-+]?\\d+e[-+]?\\d+\\s*"),
            Pattern.compile("\\s*[-+]?\\d+\\.\\d*e[-+]?\\d+\\s*"),
            Pattern.compile("\\s*[-+]?\\d*\\.\\d+e[-+]?\\d+\\s*")
    );
}
