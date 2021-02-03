package org.denis.leetcode.p0095

import org.denis.leetcode.TreeNode
import java.util.*
import kotlin.test.assertEquals

fun main() {
    assertEquals(setOf(
            TreeNode.parse("[1,null,2,null,3]"),
            TreeNode.parse("[1,null,3,2]"),
            TreeNode.parse("[2,1,3]"),
            TreeNode.parse("[3,1,null,null,2]"),
            TreeNode.parse("[3,2,null,1]")
    ), Solution().generateTrees(3).toSet())
}

class Solution {
    fun generateTrees(n: Int): List<TreeNode?> {
        return if (n <= 0) {
            emptyList()
        } else {
            generate(1, n)
        }
    }

    private fun generate(left: Int, right: Int): List<TreeNode?> {
        val result = mutableListOf<TreeNode?>()
        if (left > right) {
            result.add(null)
            return result
        }

        for (i in left..right) {
            val leftTrees = generate(left, i - 1)
            val rightTrees = generate(i + 1, right)
            for (leftTree in leftTrees) {
                for (rightTree in rightTrees) {
                    val root = TreeNode(i)
                    root.left = leftTree
                    root.right = rightTree
                    result += root
                }
            }
        }
        return result
    }
}