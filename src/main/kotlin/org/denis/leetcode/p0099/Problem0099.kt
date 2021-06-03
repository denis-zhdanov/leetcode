package org.denis.leetcode.p0099

import org.denis.leetcode.TreeNode
import java.util.*
import kotlin.test.assertEquals

fun main() {
    val solution = Solution()
//    assertEquals(TreeNode.parse("[3,1,null,null,2]"), TreeNode.parse("[1,3,null,null,2]").apply(solution::recoverTree))
//    assertEquals(TreeNode.parse("[2,1,4,null,null,3]"), TreeNode.parse("[3,1,4,null,null,2]").apply(solution::recoverTree))
    assertEquals(TreeNode.parse("[2,1,3]"), TreeNode.parse("[2,3,1]").apply(solution::recoverTree))
}

class Solution {
    fun recoverTree(root: TreeNode) {
        val toProcess = Stack<NodeEx>()
        toProcess.push(NodeEx(root, null, null))
        while (!toProcess.isEmpty()) {
            val node = toProcess.pop()
            node.min?.takeIf { it.`val` > node.node.`val` }?.let { min ->
                switch(min, node.node)
                recoverTree(root)
                return
            }
            node.max?.takeIf { it.`val` < node.node.`val` }?.let { max ->
                switch(max, node.node)
                recoverTree(root)
                return
            }
            node.node.left?.let { left ->
                toProcess.push(NodeEx(left, node.min, node.node))
            }
            node.node.right?.let { right ->
                toProcess.push(NodeEx(right, node.node, node.max))
            }
        }
    }

    private fun switch(n1: TreeNode, n2: TreeNode) {
        val tmp = n1.`val`
        n1.`val` = n2.`val`
        n2.`val` = tmp
    }

    data class NodeEx(val node: TreeNode, val min: TreeNode?, val max: TreeNode?)
}