package org.denis.leetcode.p0102

import org.denis.leetcode.TreeNode
import kotlin.test.assertEquals

fun main() {
    val solution = Solution()
    assertEquals(solution.levelOrder(TreeNode.parse("3,9,20,null,null,15,7")), listOf(listOf(3), listOf(9, 20), listOf(15, 7)))
    assertEquals(solution.levelOrder(TreeNode.parse("1")), listOf(listOf(1)))
}

class Solution {
    fun levelOrder(root: TreeNode?): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        root ?: return result

        var toProcess = mutableListOf<TreeNode>(root)
        var next = mutableListOf<TreeNode>()
        var tmp: MutableList<TreeNode>

        while (toProcess.isNotEmpty()) {
            result += toProcess.map { node ->
                node.left?.let { next.add(it) }
                node.right?.let { next.add(it) }
                node.`val`
            }
            toProcess.clear()
            tmp = toProcess
            toProcess = next
            next = tmp
        }
        return result
    }
}