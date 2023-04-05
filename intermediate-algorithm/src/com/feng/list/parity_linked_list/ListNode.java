package com.feng.list.parity_linked_list;

/**
 * ClassName: LinkNode
 * Package: com.feng.list.parity_linked_list
 * Description:
 *
 * @Author guof
 * @Create 2023/4/5 21:27
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
