package com.feng.list.adding_two_numbers;

/**
 * ClassName: ListNode
 * Package: com.feng.list.adding_two_numbers
 * Description:
 *
 * @Author guof
 * @Create 2023/4/5 21:03
 * @Version 1.0
 */
public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
