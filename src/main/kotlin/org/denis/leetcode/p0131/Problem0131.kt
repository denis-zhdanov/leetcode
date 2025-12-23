package org.denis.leetcode.p0131

import kotlin.test.assertEquals

fun main() {
    val solution = Solution()
    assertEquals(
        listOf(listOf("a","a","b"), listOf("aa","b")),
        solution.partition("aab")
    )
}

class Solution {
    fun partition(s: String): List<List<String>> {
        val result = mutableListOf<List<String>>()
        partition(0, s, mutableListOf(), result)
        return result
    }

    private fun partition(
        start: Int,
        s: String,
        path: MutableList<String>,
        result: MutableList<List<String>>
    ) {
        if (start >= s.length) {
            result.add(path.toList())
            return
        }

        for (end in start until s.length) {
            if (isPalindrome(s, start, end)) {
                path.add(s.substring(start, end + 1))
                partition(end + 1, s, path, result)
                path.removeAt(path.size - 1)
            }
        }
    }

    private fun isPalindrome(s: String, left: Int, right: Int): Boolean {
        var l = left
        var r = right
        while (l < r) {
            if (s[l] != s[r]) {
                return false
            }
            l++
            r--
        }
        return true
    }
}