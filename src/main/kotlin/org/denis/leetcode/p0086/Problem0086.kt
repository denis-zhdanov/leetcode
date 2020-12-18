package org.denis.leetcode.p0086

import org.denis.leetcode.ListNode
import org.denis.leetcode.parseListNodeList
import kotlin.test.assertEquals

fun main() {
    assertEquals(parseListNodeList("1->2->2->4->3->5"), Solution().partition(parseListNodeList("1->4->3->2->5->2"), 3))
}

class Solution {
    fun partition(head: ListNode?, x: Int): ListNode? {
        head ?: return null
        var gtHead: ListNode? = null
        var gtTail: ListNode? = null
        var ltHead: ListNode? = null
        var ltTail: ListNode? = null
        var currentNode = head
        while (currentNode != null) {
            if (currentNode.`val` < x) {
                if (ltHead == null || ltTail == null) {
                    ltHead = currentNode
                    ltTail = currentNode
                } else {
                    ltTail.next = currentNode
                    ltTail = currentNode
                }
            } else {
                if (gtHead == null || gtTail == null) {
                    gtHead = currentNode
                    gtTail = currentNode
                } else {
                    gtTail.next = currentNode
                    gtTail = currentNode
                }
            }
            val tmp = currentNode.next
            currentNode.next = null
            currentNode = tmp
        }
        return if (gtHead == null) {
            ltHead
        } else {
            if (ltHead == null || ltTail == null) {
                gtHead
            } else {
                ltTail.next = gtHead
                ltHead
            }
        }
    }
}