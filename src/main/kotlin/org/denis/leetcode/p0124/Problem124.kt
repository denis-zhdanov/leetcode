package org.denis.leetcode.p0124

import org.denis.leetcode.TreeNode
import kotlin.test.assertEquals

fun main() {
    val solution = Solution()
    assertEquals(42, solution.maxPathSum(TreeNode.parse("-10,9,20,null,null,15,7")))
    assertEquals(6, solution.maxPathSum(TreeNode.parse("1,2,3")))
}

class Solution {
    fun maxPathSum(root: TreeNode?): Int {
        val peekSum = java.util.concurrent.atomic.AtomicInteger(Int.MIN_VALUE)
        maxPathSum(root, peekSum)
        return peekSum.get()
    }

    fun maxPathSum(node: TreeNode?, peekSum: java.util.concurrent.atomic.AtomicInteger): Int {
        node ?: return 0
        val leftSum = maxOf(0, maxPathSum(node.left, peekSum))
        val rightSum = maxOf(0, maxPathSum(node.right, peekSum))
        peekSum.set(maxOf(peekSum.get(), leftSum + node.`val` + rightSum))
        return node.`val` + maxOf(leftSum, rightSum)
    }
}
