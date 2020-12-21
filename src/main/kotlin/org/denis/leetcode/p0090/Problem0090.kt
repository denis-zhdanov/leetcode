package org.denis.leetcode.p0090

import kotlin.test.assertEquals

fun main() {
    assertEquals(setOf(setOf(2), setOf(1), setOf(1, 2, 2), setOf(2, 2), setOf(1, 2), setOf()),
                 Solution().subsetsWithDup(intArrayOf(1, 2, 2)).map { it.toSet() }.toSet())
    assertEquals(setOf(emptySet(), setOf(1), setOf(1, 2), setOf(1, 2, 3), setOf(1, 3), setOf(2), setOf(2, 3), setOf(3)),
                 Solution().subsetsWithDup(intArrayOf(1, 2, 3)).map { it.toSet() }.toSet())
}

class Solution {
    fun subsetsWithDup(nums: IntArray): List<List<Int>> {
        return subsetsWithDup(nums, 0).map {
            mutableListOf<Int>().apply {
                for ((key, count) in it) {
                    repeat(count) {
                        add(key)
                    }
                }
            }
        }
    }

    private fun subsetsWithDup(nums: IntArray, start: Int): Set<Map<Int, Int>> {
        if (start >= nums.size) {
            return setOf(emptyMap())
        }
        val set = subsetsWithDup(nums, start + 1)
        val result = set.toMutableSet()
        set.forEach {
            result += it.toMutableMap().apply {
                compute(nums[start]) { _, v ->
                    if (v == null) {
                        1
                    } else {
                        v + 1
                    }
                }
            }
        }
        return result
    }
}