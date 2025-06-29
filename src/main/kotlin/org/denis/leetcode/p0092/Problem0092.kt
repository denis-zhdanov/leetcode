package org.denis.leetcode.p0092

import org.denis.leetcode.ListNode
import kotlin.test.assertEquals

fun main() {
    assertEquals(ListNode.parse(5), Solution().reverseBetween(ListNode.parse(5), 1, 1))
    assertEquals(ListNode.parse(1, 4, 3, 2, 5), Solution().reverseBetween(ListNode.parse(1, 2, 3, 4, 5), 2, 4))
}

class Solution {
    fun reverseBetween(head: ListNode?, m: Int, n: Int): ListNode? {
        head ?: return null
        var i = 1
        var previous: ListNode? = null
        var current = head
        var beforeChangeTail: ListNode? = null
        var changeHead: ListNode? = null
        var changeTail: ListNode? = null
        while (current != null) {
            val next = current.next
            if (i < m) {
                previous = current
            }
            if (i == m) {
                if (i > 1) {
                    beforeChangeTail = previous
                }
                changeTail = current
                changeHead = current
            }
            if (i > m && i < n) {
                current.next = changeHead
                changeHead = current
            }
            if (i == n) {
                changeTail?.next = current.next
                if (changeHead != current) {
                    current.next = changeHead
                }
                return if (beforeChangeTail == null) {
                    current
                } else {
                    beforeChangeTail.next = current
                    head
                }
            }
            current = next
            i++
        }
        return null
    }
}
