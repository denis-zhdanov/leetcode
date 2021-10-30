package org.denis.leetcode.p0101

import org.denis.leetcode.TreeNode
import kotlin.test.assertFalse
import kotlin.test.assertTrue

fun main() {
    val solution = Solution()
    assertTrue(solution.isSymmetric(TreeNode.parse("1,2,2,3,4,4,3")))
    assertFalse(solution.isSymmetric(TreeNode.parse("1,2,2,null,3,null,3")))
}

class Solution {
    fun isSymmetric(root: TreeNode?): Boolean {
        if (root == null) {
            return true
        }
        return areSame(root.left, root.right)
    }

    fun areSame(n1: TreeNode?, n2: TreeNode?): Boolean {
        if (n1 == null && n2 == null) {
            return true
        }
        if (((n1 == null) != (n2 == null)) || n1?.`val` != n2?.`val`) {
            return false
        }

        return areSame(n1?.left, n2?.right) && areSame(n1?.right, n2?.left)
    }
}