package org.denis.leetcode.p0061;

import org.denis.leetcode.ListNode;

public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.getNext() == null) {
            return head;
        }
        int size = getSize(head);
        if (k % size == 0) {
            return head;
        }
        ListNode newTail = get(head, size - (k % size) - 1);
        ListNode result = newTail.getNext();
        ListNode beforeOldHead = result;
        while (beforeOldHead.getNext() != null) {
            beforeOldHead = beforeOldHead.getNext();
        }
        beforeOldHead.setNext(head);
        newTail.setNext(null);
        return result;
    }

    private int getSize(ListNode head) {
        int result = 0;
        for (ListNode node = head; node != null; node = node.getNext()) {
            result++;
        }
        return result;
    }

    private ListNode get(ListNode head, int i) {
        ListNode result = head;
        for (int j = 0; j < i; j++) {
            result = result.getNext();
        }
        return result;
    }
}
