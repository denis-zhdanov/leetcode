package org.denis.leetcode

data class ListNode(
    var `val`: Int,
    var next: ListNode?
) {
    companion object {
        fun parse(vararg nums: Int): ListNode {
            val result = ListNode(nums.first(), null)
            var tail = result
            for (i in 1 until nums.size) {
                val node = ListNode(nums[i], null)
                tail.next = node
                tail = node
            }
            return result
        }
    }
}
