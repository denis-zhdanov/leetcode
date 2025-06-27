package org.denis.leetcode.p0108

import org.denis.leetcode.TreeNode
import kotlin.test.assertEquals

fun main() {
    val solution = Solution()
    assertEquals(TreeNode.parse("0, -3, 9, -10, null, 5, null"), solution.sortedArrayToBST(intArrayOf(-10, -3, 0, 5, 9)))
}

class Solution {
    fun sortedArrayToBST(nums: IntArray): TreeNode? {
        return build(nums, 0, nums.size)
    }

    fun build(data: IntArray, start: Int, end: Int): TreeNode? {
        if (start >= end) {
            return null
        }
        val rootIndex = start + (end - start) / 2
        val result = TreeNode(data[rootIndex])
        result.left = build(data, start, rootIndex)
        result.right = build(data, rootIndex + 1, end)
        return result
    }
}
