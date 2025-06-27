package org.denis.leetcode.p0106

import org.denis.leetcode.TreeNode
import kotlin.test.assertEquals

fun main() {
    val solution = Solution()
    assertEquals(TreeNode.parse("3, 9, 20, null, null, 15, 7"), solution.buildTree(intArrayOf(9, 3, 15, 20, 7), intArrayOf(9, 15, 7, 20, 3)))
    assertEquals(TreeNode.parse("-1"), solution.buildTree(intArrayOf(-1), intArrayOf(-1)))
    assertEquals(TreeNode.parse("7, -10, 2, -4, 3, -8, null, null, null, null, -1, 11"), solution.buildTree(intArrayOf(-4, -10, 3, -1, 7, 11, -8, 2), intArrayOf(-4, -1, 3, -10, 11, -8, 2, 7))
    )
}

//           7
//       /       \
//    -10         2
//    / \        /
//  -4   3     -8
//        \    /
//        -1  11

class Solution {
    fun buildTree(inorder: IntArray, postorder: IntArray): TreeNode? {
        return buildTree(Context(inorder, postorder))
    }

    fun buildTree(context: Context): TreeNode? {
        if (context.inorderStartIndex < 0) {
            return null
        }
        val rootValue = context.postorder[context.postorderEndIndex]
        val result = TreeNode(rootValue)

        val rootIndexInInorder = context.inorderValueToIndex[rootValue]!!
        val leftElementsNumber = rootIndexInInorder - context.inorderStartIndex
        if (leftElementsNumber > 0) {
            val originalInorderStartIndex = context.inorderStartIndex
            val originalInorderEndIndex = context.inorderEndIndex
            val originalPostorderStartIndex = context.postorderStartIndex
            val originalPostorderEndIndex = context.postorderEndIndex

            context.inorderEndIndex = rootIndexInInorder - 1
            context.postorderEndIndex = context.postorderStartIndex + leftElementsNumber - 1
            result.left = buildTree(context)

            context.inorderStartIndex = originalInorderStartIndex
            context.inorderEndIndex = originalInorderEndIndex
            context.postorderStartIndex = originalPostorderStartIndex
            context.postorderEndIndex = originalPostorderEndIndex
        }

        val rightElementsNumber = context.inorderEndIndex - rootIndexInInorder
        if (rightElementsNumber > 0) {
            context.inorderStartIndex = rootIndexInInorder + 1
            context.postorderStartIndex += leftElementsNumber
            context.postorderEndIndex -= 1
            result.right = buildTree(context)
        }
        return result
    }
}

data class Context(
    val inorder: IntArray,
    val postorder: IntArray,
) {
    var inorderStartIndex = 0.takeIf { inorder.isNotEmpty() } ?: -1
    var inorderEndIndex = inorder.size - 1
    var postorderStartIndex = 0
    var postorderEndIndex = postorder.size - 1

    val inorderValueToIndex = inorder.withIndex().associate { it.value to it.index }
}
