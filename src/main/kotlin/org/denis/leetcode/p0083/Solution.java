package org.denis.leetcode.p0083;

import org.denis.leetcode.ListNode;

import static org.junit.Assert.assertEquals;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        assertEquals(ListNode.Companion.parse(1, 2), solution.deleteDuplicates(ListNode.Companion.parse(1, 1, 2)));
        assertEquals(ListNode.Companion.parse(1, 2, 3), solution.deleteDuplicates(ListNode.Companion.parse(1, 1, 2, 3, 3)));
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode previous = head;
        for (ListNode node = previous.getNext(); node != null; node = node.getNext()) {
            if (previous.getVal() != node.getVal()) {
                previous.setNext(node);
                previous = node;
            } else {
                previous.setNext(null);
            }
        }
        return head;
    }
}
