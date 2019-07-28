package org.denis.leetcode.p0068;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        check(new String[]{
                      "This    is    an",
                      "example  of text",
                      "justification.  "
              }, new String[]{"This", "is", "an", "example", "of", "text", "justification."},
              16);
        check(new String[]{
                      "What   must   be",
                      "acknowledgment  ",
                      "shall be        "
              }, new String[]{"What", "must", "be", "acknowledgment", "shall", "be"},
              16);
        check(new String[]{
                      "Science  is  what we",
                      "understand      well",
                      "enough to explain to",
                      "a  computer.  Art is",
                      "everything  else  we",
                      "do                  "
              }, new String[]{
                      "Science", "is", "what", "we", "understand", "well", "enough", "to", "explain",
                      "to", "a", "computer.", "Art", "is", "everything", "else", "we", "do"
              },
              20);
        check(new String[] {"test"}, new String[] {"test"}, 4);
        check(new String[] {"test  "}, new String[] {"test"}, 6);
    }

    private static void check(String[] expected, String[] input, int maxWidth) {
        List<String> actual = new Solution().fullJustify(input, maxWidth);
        if (expected.length != actual.size()) {
            throw new IllegalArgumentException(String.format("Expected to find %d lines but got %d",
                                                             expected.length, actual.size()));
        }
        for (int i = 0; i < expected.length; i++) {
            if (!expected[i].equals(actual.get(i))) {
                throw new IllegalArgumentException(String.format(
                        "Failed expectation on line %d: expected='%s', actual='%s'", i, expected[i], actual.get(i)
                ));
            }
        }
    }

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int start = 0;
        while (start < words.length) {
            int end = nextLine(words, start, maxWidth);
            boolean lastLine = end + 1 >= words.length;
            result.add(justify(words, start, end, maxWidth, lastLine));
            start = end + 1;
        }
        return result;
    }

    private int nextLine(String[] words, int currentStart, int maxWidth) {
        int currentWidth = 0;
        int result = currentStart;
        for (; result < words.length; result++) {
            int newWidth = currentWidth + words[result].length();
            if (currentWidth > 0) {
                newWidth++;
            }
            if (newWidth == maxWidth) {
                return result;
            } else if (newWidth > maxWidth) {
                return result - 1;
            } else {
                currentWidth = newWidth;
            }
        }
        return result - 1;
    }

    private String justify(String[] words, int start, int end, int maxWidth, boolean lastLine) {
        StringBuilder result = new StringBuilder();
        if (start == end) {
            result.append(words[start]);
            int ws = maxWidth - result.length();
            while (--ws >= 0) {
                result.append(' ');
            }
            return result.toString();
        }
        if (lastLine) {
            for (int i = start; i <= end; i++) {
                if (result.length() > 0) {
                    result.append(' ');
                }
                result.append(words[i]);
            }
            int ws = maxWidth - result.length();
            while (--ws >= 0) {
                result.append(' ');
            }
            return result.toString();
        }
        int wordGapsNumber = end - start;
        int payloadWidth = 0;
        for (int i = start; i <= end; i++) {
            payloadWidth += words[i].length();
        }
        int wsNumber = maxWidth - payloadWidth;
        int unevenWsNumber = wsNumber % wordGapsNumber;
        int evenWsNumber = wsNumber / wordGapsNumber;
        int gapIndex = 1;
        for (int i = start; i <= end; i++) {
            if (result.length() > 0) {
                int ws = evenWsNumber;
                if (gapIndex++ <= unevenWsNumber) {
                    ws++;
                }
                while (--ws >= 0) {
                    result.append(' ');
                }
            }
            result.append(words[i]);
        }
        return result.toString();
    }
}
