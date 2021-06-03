package org.denis.leetcode.p0100

import org.denis.leetcode.TreeNode
import java.util.*
import kotlin.test.assertFalse
import kotlin.test.assertTrue

fun main() {
    val solution = Solution()
    assertTrue(solution.isSameTree(TreeNode.parse("1,2,3"), TreeNode.parse("1,2,3")))
    assertFalse(solution.isSameTree(TreeNode.parse("1,2"), TreeNode.parse("1,null,2")))
}

class Solution {
    fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean {
        val toCheck = Stack<Pair<TreeNode?, TreeNode?>>()
        toCheck.push(p to q)
        while (!toCheck.isEmpty()) {
            val (n1, n2) = toCheck.pop()
            when {
                n1?.`val` != n2?.`val` -> return false
                n1 != null && n2 != null -> {
                    toCheck.push(n1.left to n2.left)
                    toCheck.push(n1.right to n2.right)
                }
            }
        }
        return true
    }
}