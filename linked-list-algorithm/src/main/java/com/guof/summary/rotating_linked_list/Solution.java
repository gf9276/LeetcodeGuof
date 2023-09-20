package com.guof.summary.rotating_linked_list;


class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return null;

        // 双指针，第一个先走k步
        ListNode moveSlow = head;
        ListNode moveFast = head;

        for (int i = 0; i < k; i++) {
            moveFast = moveFast.next;
            if (moveFast == null) {
                moveFast = head;
                k = k % (i + 1);
                i = -1;
            }
        }

        if (moveFast.equals(moveSlow)) return head;

        while (moveFast.next != null) {
            moveFast = moveFast.next;
            moveSlow = moveSlow.next;
        }


        ListNode output = moveSlow.next;
        moveSlow.next = null;
        moveFast.next = head;

        return output;

    }

}