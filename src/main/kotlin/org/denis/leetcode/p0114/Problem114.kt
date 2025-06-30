package org.denis.leetcode.p0114

import org.denis.leetcode.TreeNode
import kotlin.test.assertEquals

fun main() {
    val solution = Solution()
    assertEquals(TreeNode.parse("1,null,2,null,3,null,4,null,5,null,6"), TreeNode.parse("1,2,5,3,4,null,6").apply {
        solution.flatten(this)
    })
    assertEquals(TreeNode.parse("0"), TreeNode.parse("0").apply {
        solution.flatten(this)
    })
}

class Solution {
    fun flatten(root: TreeNode?) {
        root ?: return
        val right = root.right
        val tail = flatten(root.left, root)
        root.left = null
        flatten(right, tail)
    }

    fun flatten(node: TreeNode?, tail: TreeNode): TreeNode {
        node ?: return tail
        val right = node.right
        tail.right = node
        val newTail = flatten(node.left, node)
        node.left = null
        return flatten(right, newTail).also {
            right?.left = null
        }
    }
}
