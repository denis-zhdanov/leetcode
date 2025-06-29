package org.denis.leetcode.p0113

import org.denis.leetcode.TreeNode
import kotlin.test.assertEquals

fun main() {
    val solution = Solution()
    assertEquals(
        listOf(listOf(5, 4, 11, 2), listOf(5, 8, 4, 5)),
        solution.pathSum(TreeNode.parse("5,4,8,11,null,13,4,7,2,null,null,5,1"), 22)
    )
    assertEquals(
        emptyList(),
        solution.pathSum(TreeNode.parse("1,2,3"), 5)
    )
}

class Solution {
    fun pathSum(root: TreeNode?, targetSum: Int): List<List<Int>> {
        root ?: return emptyList()
        val result = mutableListOf<List<Int>>()
        pathSum(root, targetSum, mutableListOf(), result)
        return result
    }

    fun pathSum(node: TreeNode?, targetSum: Int, candidate: MutableList<Int>, result: MutableList<List<Int>>) {
        node ?: return
        if (node.left == null && node.right == null && node.`val` == targetSum) {
            candidate += node.`val`
            result += candidate.toList()
            candidate.removeLast()
            return
        }
        candidate +=  node.`val`
        pathSum(node.left, targetSum - node.`val`, candidate, result)
        pathSum(node.right, targetSum - node.`val`, candidate, result)
        candidate.removeLast()
    }
}
