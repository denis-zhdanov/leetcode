package org.denis.leetcode.p0111

import org.denis.leetcode.TreeNode
import org.junit.Assert.assertEquals
import java.util.LinkedList

fun main() {
    val solution = Solution()
    assertEquals(2, solution.minDepth(TreeNode.parse("3,9,20,null,null,15,7")))
    assertEquals(5, solution.minDepth(TreeNode.parse("2,null,3,null,4,null,5,null,6")))
}

class Solution {
    fun minDepth(root: TreeNode?): Int {
        root ?: return 0

        var toProcess = LinkedList<TreeNode>()
        var nextLevel = LinkedList<TreeNode>()
        var tmp: LinkedList<TreeNode>
        var result = 1

        toProcess += root
        while (toProcess.isNotEmpty()) {
            while (toProcess.isNotEmpty()) {
                val node = toProcess.removeFirst()
                if (node.left == null && node.right == null) {
                    return result
                }
                node.left?.let { nextLevel += it }
                node.right?.let { nextLevel += it }
            }
            tmp = toProcess
            toProcess = nextLevel
            nextLevel = tmp
            result++
        }
        return result
    }
}
