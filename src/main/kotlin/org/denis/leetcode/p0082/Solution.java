package org.denis.leetcode.p0082;

import org.denis.leetcode.ListNode;

import static kotlin.test.AssertionsKt.assertEquals;


public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        assertEquals(ListNode.Companion.parse(1), solution.deleteDuplicates(ListNode.Companion.parse(1, 2, 2)), "");
        assertEquals(ListNode.Companion.parse(1, 2, 5), solution.deleteDuplicates(ListNode.Companion.parse(1, 2, 3, 3, 4, 4, 5)), "");
        assertEquals(ListNode.Companion.parse(2, 3), solution.deleteDuplicates(ListNode.Companion.parse(1, 1, 1, 2, 3)), "");
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode previous = null;
        ListNode current = head;
        boolean addCurrent = true;
        ListNode result = null;
        for (ListNode node = head.getNext(); node != null; node = node.getNext()) {
            if (current.getVal() == node.getVal()) {
                addCurrent = false;
                continue;
            }
            if (addCurrent) {
                if (result == null) {
                    result = current;
                }
                if (previous != null) {
                    previous.setNext(current);
                }
                previous = current;
            } else if (previous != null) {
                previous.setNext(null);
            }
            current = node;
            addCurrent = true;
        }
        if (addCurrent) {
            if (previous != null) {
                previous.setNext(current);
            }
            if (result == null) {
                return current;
            }
        } else if (previous != null) {
            previous.setNext(null);
        }
        return result;
    }
}
