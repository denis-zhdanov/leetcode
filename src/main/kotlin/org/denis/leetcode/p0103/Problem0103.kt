package org.denis.leetcode.p0103

import org.denis.leetcode.TreeNode
import kotlin.test.assertEquals

//           1
//         /  \
//       2     3
//     /        \
//    4          5
fun main() {
    val solution = Solution()
    assertEquals(listOf(listOf(3), listOf(20, 9), listOf(15, 7)), solution.zigzagLevelOrder(TreeNode.parse("3,9,20,null,null,15,7")))
    assertEquals(listOf(listOf(1), listOf(3, 2), listOf(4, 5)), solution.zigzagLevelOrder(TreeNode.parse("[1,2,3,4,null,null,5]")))
    assertEquals(listOf(listOf(1)), solution.zigzagLevelOrder(TreeNode.parse("1")))
}

class Solution {
    fun zigzagLevelOrder(root: TreeNode?): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        root ?: return result

        var toProcess = mutableListOf(root)
        var next = mutableListOf<TreeNode>()
        var tmp: MutableList<TreeNode>
        var reverse = false

        while (toProcess.isNotEmpty()) {
            result += toProcess.map { node ->
                node.left?.let { next.add(it) }
                node.right?.let { next.add(it) }
                node.`val`
            }.let {
                if (reverse) {
                    it.asReversed()
                } else {
                    it
                }
            }
            reverse = !reverse
            toProcess.clear()
            tmp = toProcess
            toProcess = next
            next = tmp
        }
        return result
    }
}