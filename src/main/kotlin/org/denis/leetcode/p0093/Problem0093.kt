package org.denis.leetcode.p0093

import kotlin.test.assertEquals

fun main() {
    assertEquals(setOf("255.255.11.135", "255.255.111.35"), Solution().restoreIpAddresses("25525511135").toSet())
    assertEquals(setOf("0.0.0.0"), Solution().restoreIpAddresses("0000").toSet())
    assertEquals(setOf("1.1.1.1"), Solution().restoreIpAddresses("1111").toSet())
    assertEquals(setOf("0.10.0.10", "0.100.1.0"), Solution().restoreIpAddresses("010010").toSet())
    assertEquals(setOf("1.0.10.23", "1.0.102.3", "10.1.0.23", "10.10.2.3", "101.0.2.3"),
                 Solution().restoreIpAddresses("101023").toSet())
}

class Solution {
    fun restoreIpAddresses(s: String): List<String> {
        return restore(s, 0, 4)?.map {
            it.joinToString(".")
        } ?: emptyList()
    }

    private fun restore(s: String, i: Int, remaining: Int): Set<List<String>>? {
        if (remaining == 0) {
            return if (i < s.length) {
                null
            } else {
                emptySet()
            }
        }
        if (i >= s.length) {
            return null
        }
        val result = mutableSetOf<List<String>>()
        restore(s, i + 1, remaining - 1)?.let { subs ->
            val base = listOf(s[i].toString())
            add(result, base, subs)
        }
        if (s[i] != '0' && i < s.length - 1) {
            restore(s, i + 2, remaining - 1)?.let { subs ->
                val base = listOf(s.substring(i, i + 2))
                add(result, base, subs)
            }
        }
        if (s[i] != '0' && i < s.length - 2) {
            val base = listOf(s.substring(i, i + 3))
            if (base[0].toInt() <= 255) {
                restore(s, i + 3, remaining - 1)?.let { subs ->
                    add(result, base, subs)
                }
            }
        }
        return result.takeUnless { it.isEmpty() }
    }

    private fun add(holder: MutableSet<List<String>>, base: List<String>, tails: Set<List<String>>?) {
        if (tails == null) {
            return
        }
        if (tails.isEmpty()) {
            holder += setOf(base)
        } else {
            tails.forEach { sub ->
                holder += base + sub
            }
        }
    }
}