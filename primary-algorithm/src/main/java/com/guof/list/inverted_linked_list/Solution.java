package com.guof.list.inverted_linked_list;

/**
 * ClassName: Solution
 * Package: com.feng.inverted_linked_list
 * Description:
 *
 * @Author guof
 * @Create 2023/3/25 18:46
 * @Version 1.0
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode p_1 = head; // 正数过去的
        ListNode p_2 = null;
        ListNode now_head = head;

        for (; ; ) {
            now_head = now_head.next; // 直接指向下一个
            p_1.next = p_2; // 下一个对应的是p_2
            p_2 = p_1; // 更新p2
            p_1 = now_head; // 更新p1
            if (now_head == null) {
                break;
            }

        }
        return p_2;
    }
}