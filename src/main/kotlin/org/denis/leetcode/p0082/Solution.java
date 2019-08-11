package org.denis.leetcode.p0082;

import org.denis.leetcode.ListNode;

import static org.assertj.core.api.Assertions.assertThat;
import static org.denis.leetcode.UtilKt.buildList;

public class Solution {

    public static void main(String[] args) {
        assertThat(new Solution().deleteDuplicates(buildList(1, 2, 2))).isEqualTo(buildList(1));
        assertThat(new Solution().deleteDuplicates(buildList(1, 2, 3, 3, 4, 4, 5))).isEqualTo(buildList(1, 2, 5));
        assertThat(new Solution().deleteDuplicates(buildList(1, 1, 1, 2, 3))).isEqualTo(buildList(2, 3));
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode previous = null;
        ListNode current = head;
        boolean addCurrent = true;
        ListNode result = null;
        for (ListNode node = head.next; node != null; node = node.next) {
            if (current.val == node.val) {
                addCurrent = false;
                continue;
            }
            if (addCurrent) {
                if (result == null) {
                    result = current;
                }
                if (previous != null) {
                    previous.next = current;
                }
                previous = current;
            } else if (previous != null) {
                previous.next = null;
            }
            current = node;
            addCurrent = true;
        }
        if (addCurrent) {
            if (previous != null) {
                previous.next = current;
            }
            if (result == null) {
                return current;
            }
        } else if (previous != null) {
            previous.next = null;
        }
        return result;
    }
}
