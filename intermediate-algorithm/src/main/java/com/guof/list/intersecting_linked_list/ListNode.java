package com.guof.list.intersecting_linked_list;

/**
 * ClassName: ListNode
 * Package: com.feng.list.intersecting_linked_list
 * Description:
 *
 * @Author guof
 * @Create 2023/4/6 16:09
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
