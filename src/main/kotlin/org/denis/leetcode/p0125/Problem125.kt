package org.denis.leetcode.p0125

import kotlin.test.assertEquals

fun main() {
    val solution = Solution()
    assertEquals(true, solution.isPalindrome("A man, a plan, a canal: Panama"))
    assertEquals(false, solution.isPalindrome("race a car"))
    assertEquals(true, solution.isPalindrome(" "))
    assertEquals(false, solution.isPalindrome("0P"))
}

class Solution {
    fun isPalindrome(s: String): Boolean {
        var leftIndex = 0
        var rightIndex = s.length - 1
        while (leftIndex < rightIndex) {
            while (leftIndex < rightIndex) {
                if (!s[leftIndex].isLetterOrDigit()) {
                    leftIndex++
                    continue
                } else {
                    break
                }
            }
            if (leftIndex >= rightIndex) {
                return true
            }
            while (leftIndex < rightIndex) {
                if (!s[rightIndex].isLetterOrDigit()) {
                    rightIndex--
                    continue
                } else {
                    break
                }
            }
            if (leftIndex >= rightIndex) {
                return true
            }
            if (s[leftIndex].lowercaseChar() != s[rightIndex].lowercaseChar()) {
                return false
            }
            leftIndex++
            rightIndex--
        }
        return true
    }
}
