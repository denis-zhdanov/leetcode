package org.denis.leetcode.p0127

import kotlin.test.assertEquals

fun main() {
    val solution = Solution()
    assertEquals(
        2,
        solution.ladderLength("hog", "cog", listOf("cog"))
    )
    assertEquals(
        5,
        solution.ladderLength("hit", "cog", listOf("hot","dot","dog","lot","log","cog"))
    )
    assertEquals(
        0,
        solution.ladderLength("hit", "cog", listOf("hot","dot","dog","lot","log"))
    )
    assertEquals(
        2,
        solution.ladderLength("a", "c", listOf("a","b","c"))
    )
}

class Solution {
    fun ladderLength(beginWord: String, endWord: String, wordList: List<String>): Int {
        val words = wordList.toMutableSet()
        if (!words.contains(endWord)) {
            return 0
        }
        if (!words.contains(beginWord)) {
            words += beginWord
        }
        val chainTailLengths = mutableMapOf<String, Int>()
        chainTailLengths[endWord] = 1
        var current: MutableList<String> = mutableListOf(endWord)
        var next = mutableListOf<String>()
        var tmp: MutableList<String>
        var result = -1
        while (current.isNotEmpty()) {
            for (word in current) {
                for (candidate in words) {
                    if (isAdjacent(word, candidate)) {
                        val knownLength = chainTailLengths[candidate]
                        val candidateLength = chainTailLengths[word]!! + 1
                        if (knownLength == null || candidateLength < knownLength) {
                            var candidateResult = -1
                            if (candidate == beginWord) {
                                candidateResult = candidateLength
                            }
                            if (candidateResult > 0 && (result < 0 || result > candidateResult)) {
                                result = candidateResult
                            }
                            chainTailLengths[candidate] = candidateLength
                            next += candidate
                        }
                    }
                }
            }
            if (result > 0) {
                return result
            }
            current.clear()
            tmp = current
            current = next
            next = tmp
        }
        return 0
    }

    fun isAdjacent(w1: String, w2: String): Boolean {
        if (w1.length != w2.length) {
            return false
        }
        var differences = 0
        for (i in (0 until w1.length)) {
            if (w1[i] != w2[i]) {
                if (differences > 0) {
                    return false
                } else {
                    differences++
                }
            }
        }
        return differences > 0
    }
}