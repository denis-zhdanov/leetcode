package org.denis.leetcode.p0105

import org.denis.leetcode.TreeNode
import kotlin.test.assertEquals

fun main() {
    val solution = Solution()
    assertEquals(TreeNode.parse("3, 9, 20, null, null, 15, 7"), solution.buildTree(intArrayOf(3, 9, 20, 15, 7), intArrayOf(9, 3, 15, 20, 7)))
    assertEquals(TreeNode.parse("-1"), solution.buildTree(intArrayOf(-1), intArrayOf(-1)))
    assertEquals(TreeNode.parse("1, null, 2"), solution.buildTree(intArrayOf(1, 2), intArrayOf(1, 2)))
}

class Solution {
    fun buildTree(preorder: IntArray, inorder: IntArray): TreeNode? {
        return buildTree(Context(preorder, inorder))
    }

    fun buildTree(context: Context): TreeNode? {
        if (context.rootIndexInPreoder < 0) {
            return null
        }
        val rootValue = context.preorder[context.rootIndexInPreoder]
        val result = TreeNode(rootValue)
        val rootIndexInInorder = context.inorderValue2Index[rootValue]
                                 ?: throw IllegalStateException("Root value $rootValue not found in inorder array")
        val treeSize = context.treeSize
        val leftSubTreeNodesNumber = rootIndexInInorder - context.inorderStartIndex
        if (leftSubTreeNodesNumber > 0) {
            val originalRootIndexInPreorder = context.rootIndexInPreoder
            val originalInorderStartIndex = context.inorderStartIndex
            val originalTreeSize = context.treeSize
            context.rootIndexInPreoder++
            context.treeSize = leftSubTreeNodesNumber
            result.left = buildTree(context)
            context.treeSize = originalTreeSize
            context.rootIndexInPreoder = originalRootIndexInPreorder + leftSubTreeNodesNumber
            context.inorderStartIndex = originalInorderStartIndex + leftSubTreeNodesNumber
        }

        // handle root node
        context.rootIndexInPreoder++
        context.inorderStartIndex++

        val rightSubTreeNodesNumber = treeSize - leftSubTreeNodesNumber - 1 // -1 for the root node
        if (rightSubTreeNodesNumber > 0) {
            context.treeSize = rightSubTreeNodesNumber
            result.right = buildTree(context)
        }

        return result
    }
}

data class Context(
    val preorder: IntArray,
    val inorder: IntArray,
) {
    val inorderValue2Index = inorder.withIndex().associate { it.value to it.index }
    var rootIndexInPreoder = 0.takeIf { preorder.isNotEmpty() } ?: -1
    var inorderStartIndex = 0
    var treeSize = preorder.size
}
