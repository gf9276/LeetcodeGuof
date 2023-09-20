package com.guof.list.delete_the_penultimate_node_of_the_linked_list;

/**
 * ClassName: Solution
 * Package: com.feng.delete_the_penultimate_node_of_the_linked_list
 * Description:
 *
 * @Author guof
 * @Create 2023/3/25 18:26
 * @Version 1.0
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode p_2 = head;
        ListNode p_1 = head;


        for (int i = 0; i < n; i++) {
            p_2 = p_2.next;
        }

        if (p_2 == null) {
            head = head.next;
            return head;
        }

        for (; ; ) {
            if (p_2.next == null) {
                // 如果到了末尾
                p_1.next = p_1.next.next;
                break;
            }

            p_2 = p_2.next;
            p_1 = p_1.next;
        }

        return head;
    }
}