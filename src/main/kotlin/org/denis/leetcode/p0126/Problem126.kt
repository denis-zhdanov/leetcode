package org.denis.leetcode.p0126

import kotlin.test.assertEquals

fun main() {
    val solution = Solution()
    assertEquals(
        listOf(listOf("hit", "hot", "dot", "dog", "cog"), listOf("hit", "hot", "lot", "log", "cog")),
        solution.findLadders("hit", "cog", listOf("hot", "dot", "dog", "lot", "log", "cog"))
    )
    assertEquals(
        emptyList(),
        solution.findLadders("hit", "cog", listOf("hot", "dot", "dog", "lot", "log"))
    )
//    assertEquals(
//        emptyList(),
//        solution.findLadders("qa", "sq", listOf("si","go","se","cm","so","ph","mt","db","mb","sb","kr","ln","tm","le","av","sm","ar","ci","ca","br","ti","ba","to","ra","fa","yo","ow","sn","ya","cr","po","fe","ho","ma","re","or","rn","au","ur","rh","sr","tc","lt","lo","as","fr","nb","yb","if","pb","ge","th","pm","rb","sh","co","ga","li","ha","hz","no","bi","di","hi","qa","pi","os","uh","wm","an","me","mo","na","la","st","er","sc","ne","mn","mi","am","ex","pt","io","be","fm","ta","tb","ni","mr","pa","he","lr","sq","ye"))
//    )
}

class Solution {
    fun findLadders(beginWord: String, endWord: String, wordList: List<String>): List<List<String>> {
        val wordSet = wordList.toMutableSet()
        if (endWord !in wordSet) {
            return emptyList()
        }

        val parents = mutableMapOf<String, MutableSet<String>>()
        var level = mutableSetOf(beginWord)
        var found = false

        while (level.isNotEmpty() && !found) {
            val nextLevel = mutableMapOf<String, MutableSet<String>>()
            wordSet.removeAll(level)

            for (word in level) {
                for (i in word.indices) {
                    for (c in 'a'..'z') {
                        if (c == word[i]) continue
                        val newWord = word.substring(0, i) + c + word.substring(i + 1)
                        if (newWord in wordSet) {
                            nextLevel.computeIfAbsent(newWord) { mutableSetOf() }.add(word)
                            if (newWord == endWord) found = true
                        }
                    }
                }
            }

            for ((child, parentSet) in nextLevel) {
                parents.computeIfAbsent(child) { mutableSetOf() }.addAll(parentSet)
            }

            level = nextLevel.keys.toMutableSet()
        }

        val results = mutableListOf<List<String>>()

        fun backtrack(word: String, path: MutableList<String>) {
            if (word == beginWord) {
                results.add(listOf(beginWord) + path.reversed())
                return
            }
            for (p in parents[word] ?: emptySet()) {
                path.add(word)
                backtrack(p, path)
                path.removeAt(path.lastIndex)
            }
        }

        if (found) backtrack(endWord, mutableListOf())

        return results
    }
}
