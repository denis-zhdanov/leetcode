package org.denis.leetcode.p0098

import org.denis.leetcode.TreeNode
import kotlin.test.assertFalse
import kotlin.test.assertTrue

fun main() {
    assertTrue(Solution().isValidBST(TreeNode.parse("[2, 1, 3]")))
    assertFalse(Solution().isValidBST(TreeNode.parse("[5,1,4,null,null,3,6]")))
}

class Solution {
    fun isValidBST(root: TreeNode?): Boolean {
        root ?: return true
        return solve(root.left, null, root.`val`) && solve(root.right, root.`val`, null)
    }

    fun solve(root: TreeNode?, min: Int?, max: Int?): Boolean {
        root ?: return true
        return (min == null || min < root.`val`)
                && (max == null || max > root.`val`)
                && solve(root.left, min, root.`val`)
                && solve(root.right, root.`val`, max)
    }
}