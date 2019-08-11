package org.denis.leetcode.p0083;

import org.denis.leetcode.ListNode;

import static org.assertj.core.api.Assertions.assertThat;
import static org.denis.leetcode.UtilKt.buildList;

public class Solution {

    public static void main(String[] args) {
        assertThat(new Solution().deleteDuplicates(buildList(1, 1, 2))).isEqualTo(buildList(1, 2));
        assertThat(new Solution().deleteDuplicates(buildList(1, 1, 2, 3, 3))).isEqualTo(buildList(1, 2, 3));
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode previous = head;
        for (ListNode node = previous.next; node != null; node = node.next) {
            if (previous.val != node.val) {
                previous.next = node;
                previous = node;
            } else {
                previous.next = null;
            }
        }
        return head;
    }
}
