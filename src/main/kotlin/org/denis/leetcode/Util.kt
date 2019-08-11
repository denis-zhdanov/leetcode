package org.denis.leetcode

fun buildList(vararg data: Int): ListNode {
    val result = ListNode(data[0])
    var tail = result
    (1 until data.size).forEach { i ->
        val node = ListNode(data[i])
        tail.next = node
        tail = node
    }
    return result
}