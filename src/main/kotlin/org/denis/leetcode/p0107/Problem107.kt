package org.denis.leetcode.p0107

import org.denis.leetcode.TreeNode
import kotlin.test.assertEquals
import java.util.LinkedList

fun main() {
    val solution = Solution()
    assertEquals(listOf(listOf(15, 7), listOf(9, 20), listOf(3)), solution.levelOrderBottom(TreeNode.parse("3, 9, 20, null, null, 15, 7")))
    assertEquals(listOf(listOf(1)), solution.levelOrderBottom(TreeNode.parse("1")))
    assertEquals(listOf(), solution.levelOrderBottom(null))
}

class Solution {
    fun levelOrderBottom(root: TreeNode?): List<List<Int>> {
        if (root == null) {
            return emptyList()
        }
        val result = mutableListOf<MutableList<Int>>()
        var currentLevelNodes = LinkedList<TreeNode>()
        var nextLevelNodes = LinkedList<TreeNode>()
        var currentLevelValues = mutableListOf<Int>()
        var tmp: LinkedList<TreeNode>
        currentLevelNodes += root
        while (currentLevelNodes.isNotEmpty()) {
            while (currentLevelNodes.isNotEmpty()) {
                val node = currentLevelNodes.removeFirst()
                currentLevelValues += node.`val`
                node.left?.let { nextLevelNodes += it }
                node.right?.let { nextLevelNodes += it }
            }
            tmp = currentLevelNodes
            currentLevelNodes = nextLevelNodes
            nextLevelNodes = tmp
            result += currentLevelValues
            currentLevelValues = mutableListOf()
        }
        return result.reversed()
    }
}
