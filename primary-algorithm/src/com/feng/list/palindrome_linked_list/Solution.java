package com.feng.list.palindrome_linked_list;

/**
 * ClassName: Solution
 * Package: com.feng.palindrome_linked_list
 * Description:
 *
 * @Author guof
 * @Create 2023/3/25 19:17
 * @Version 1.0
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        // 寻找中间节点，反转后半部分
        ListNode p_1 = head;
        ListNode p_2 = head;

        // p_1指向后半部分
        for (; ; ) {
            p_1 = p_1.next;  // 速度问题
            p_2 = p_2.next;
            if (p_2 == null) {
                break;  // 奇数个节点
            }
            p_2 = p_2.next;
            if (p_2 == null) {
                break; // 偶数个节点
            }
        }


        p_1 = reverseList(p_1);

        while (p_1 != null) {
            if (p_1.val != head.val) {
                return false;
            }
            p_1 = p_1.next;
            head = head.next;
        }

        return true;
    }

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