package org.denis.leetcode.p0129

import org.denis.leetcode.TreeNode
import kotlin.test.assertEquals

fun main() {
    val solution = Solution()
    assertEquals(
        10,
        solution.sumNumbers(TreeNode.parse("[1,0]"))
    )
    assertEquals(
        25,
        solution.sumNumbers(TreeNode.parse("[1,2,3]"))
    )
    assertEquals(
        1026,
        solution.sumNumbers(TreeNode.parse("[4,9,0,5,1]"))
    )
}

class Solution {
    fun sumNumbers(root: TreeNode?): Int {
        return sumNumbers(0, root)
    }

    fun sumNumbers(current: Int, root: TreeNode?): Int {
        root ?: return current
        val parentAndNodeValue = current * 10 + root.`val`
        return if (root.left == null && root.right == null) {
            parentAndNodeValue
        } else {
            val leftValue = root.left?.let {
                sumNumbers(parentAndNodeValue, it)
            } ?: 0
            val rightValue = root.right?.let {
                sumNumbers(parentAndNodeValue, it)
            } ?: 0
            leftValue + rightValue
        }
    }
}