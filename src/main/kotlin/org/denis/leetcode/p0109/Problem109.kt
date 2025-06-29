package org.denis.leetcode.p0109

import org.denis.leetcode.ListNode
import org.denis.leetcode.TreeNode
import kotlin.test.assertEquals

fun main() {
    val solution = Solution()
    assertEquals(TreeNode.parse("0,-3,9,-10,null,5"), solution.sortedListToBST(ListNode.parse(-10, -3, 0, 5, 9)))
}

class Solution {

    fun calculateSize(head: ListNode): Int {
        var i = 0
        var node: ListNode? = head
        while (node != null) {
            i++
            node = node.next
        }
        return i
    }

    fun sortedListToBST(head: ListNode?): TreeNode? {
        head ?: return null
        val size = calculateSize(head)
        return build(java.util.concurrent.atomic.AtomicReference(head), 0, size)
    }

    fun build(listRef: java.util.concurrent.atomic.AtomicReference<ListNode?>, start: Int, end: Int): TreeNode? {
        val leftList = listRef.get()
        if (leftList == null || start >= end)  {
            return null
        }
        if (start == end - 1) {
            listRef.set(leftList.next)
            return TreeNode(leftList.`val`)
        }
        val rootIndex = (start + end) / 2
        val left = build(listRef, start, rootIndex)
        val rootList = listRef.get()!!
        val result = TreeNode(rootList.`val`)
        result.left = left
        listRef.set(rootList.next)
        result.right = build(listRef, rootIndex + 1, end)
        return result
    }
}
