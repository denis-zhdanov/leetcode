package org.denis.leetcode.p0104

import org.denis.leetcode.TreeNode
import kotlin.test.assertEquals

fun main() {
    val solution = Solution()
    assertEquals(3, solution.maxDepth(TreeNode.parse("3,9,20,null,null,15,7")))
    assertEquals(2, solution.maxDepth(TreeNode.parse("1,null,2")))
    assertEquals(1, solution.maxDepth(TreeNode.parse("1")))
    assertEquals(0, solution.maxDepth(null))
}

class Solution {
    fun maxDepth(root: TreeNode?): Int {
        root ?: return 0
        var result = 0
        var toProcess = mutableListOf(root)
        var next = mutableListOf<TreeNode>()
        var tmp: MutableList<TreeNode>
        while (toProcess.isNotEmpty()) {
            ++result
            for (node in toProcess) {
                node.left?.let { next.add(it) }
                node.right?.let { next.add(it) }
            }
            toProcess.clear()
            tmp = toProcess
            toProcess = next
            next = tmp
        }
        return result
    }
}