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

fun parseListNodeList(s: String): ListNode {
    val parts = s.split("->")
    val head = ListNode(parts[0].toInt())
    parts.subList(1, parts.size).fold(head) { tail, part ->
        ListNode(part.toInt()).apply {
            tail.next = this
        }
    }
    return head
}

fun parseDoubleCharArray(s: String): Array<CharArray> {
    return s
        .substring(2, s.length - 2)
        .split("],[")
        .map { parseCharArray("[$it]") }
        .toTypedArray()
}

fun parseCharArray(s: String): CharArray {
    return s
        .substring(1, s.length - 1)
        .split(",")
        .filter(String::isNotBlank)
        .map { it[1] }
        .toCharArray()
}