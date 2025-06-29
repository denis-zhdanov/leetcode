package org.denis.leetcode.p0112

import org.denis.leetcode.TreeNode
import kotlin.test.assertEquals

fun main() {
    val solution = Solution()
    assertEquals(true, solution.hasPathSum(TreeNode.parse("5,4,8,11,null,13,4,7,2,null,null,null,1"), 22))
    assertEquals(false, solution.hasPathSum(TreeNode.parse("1,2,3"), 5))
    assertEquals(true, solution.hasPathSum(TreeNode.parse("-2,null,-3"), -5))
}

class Solution {
    fun hasPathSum(root: TreeNode?, targetSum: Int): Boolean {
        root ?: return false
        if (root.left == null && root.right == null && root.`val` == targetSum) {
            return true
        }
        return hasPathSum(root.left, targetSum - root.`val` ) || hasPathSum(root.right, targetSum - root.`val`)
    }
}
