package com.feng.list.circular_linked_list;

/**
 * ClassName: Solution
 * Package: com.feng.list.circular_linked_list
 * Description:
 *
 * @Author guof
 * @Create 2023/3/25 21:39
 * @Version 1.0
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode p1 = head;
        if (p1 == null) {
            return false;
        }
        ListNode p2 = head.next;
        if (p2 == null) {
            return false;
        }

        for (; ; ) {
            p1 = p1.next;
            p2 = p2.next;
            if (p2 == null) {
                return false;
            } else if (p1 == p2) {
                return true;
            }
            p2 = p2.next;
            if (p2 == null) {
                return false;
            } else if (p1 == p2) {
                return true;
            }
        }
    }
}