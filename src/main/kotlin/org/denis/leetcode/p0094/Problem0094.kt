package org.denis.leetcode.p0094

import org.denis.leetcode.TreeNode
import java.util.*
import kotlin.test.assertEquals

fun main() {
    val solution = Solution()
    assertEquals(listOf(1, 3, 2), solution.inorderTraversal(TreeNode.parse("[1,null,2,3]")))
    assertEquals(emptyList(), solution.inorderTraversal(null))
    assertEquals(listOf(1), solution.inorderTraversal(TreeNode.parse("[1]")))
    assertEquals(listOf(2, 1), solution.inorderTraversal(TreeNode.parse("[1,2]")))
    assertEquals(listOf(1, 2), solution.inorderTraversal(TreeNode.parse("[1,null,2]")))
}

class Solution {
    fun inorderTraversal(root: TreeNode?): List<Int> {
        root ?: return emptyList()
        return mutableListOf<Int>().apply {
            val next = Stack<NodeEx>()
            next += NodeEx(root)
            while (next.isNotEmpty()) {
                val node = next.pop()
                if (!node.leftIsDone) {
                    node.leftIsDone = true
                    val left = node.node.left
                    if (left != null) {
                        next += node
                        next += NodeEx(left)
                        continue
                    }
                }
                this += node.node.`val`
                node.node.right?.let {
                    next += NodeEx(it)
                }
            }
        }
    }
}

data class NodeEx(val node: TreeNode, var leftIsDone: Boolean = false)