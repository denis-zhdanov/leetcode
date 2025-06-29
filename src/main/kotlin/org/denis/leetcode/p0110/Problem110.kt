package org.denis.leetcode.p0110

import org.denis.leetcode.TreeNode
import kotlin.test.assertEquals

fun main() {
    val solution = Solution()
    assertEquals(false, solution.isBalanced(TreeNode.parse("1,null,2,null,3")))
    assertEquals(true, solution.isBalanced(TreeNode.parse("3,9,20,null,null,15,7")))
    assertEquals(false, solution.isBalanced(TreeNode.parse("1,2,2,3,3,null,null,4,4")))
    assertEquals(true, solution.isBalanced(null))
}

class Solution {
    fun isBalanced(root: TreeNode?): Boolean {
        return getDepthIfBalanced(root) != null
    }

    fun getDepthIfBalanced(node: TreeNode?): Int? {
        node ?: return 0
        return getDepthIfBalanced(node.left)?.let { leftDepth ->
            getDepthIfBalanced(node.right)?.let { rightDepth ->
                if (kotlin.math.abs(leftDepth - rightDepth) <= 1) {
                    kotlin.math.max(leftDepth, rightDepth) + 1
                } else {
                    null
                }
            }
        }
    }
}
