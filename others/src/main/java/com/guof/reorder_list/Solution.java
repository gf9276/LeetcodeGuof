package com.guof.reorder_list;


import java.util.*;

class Solution {
    public void reorderList(ListNode head) {
        // 使用 dequeue 模拟 stack
        Deque<ListNode> queue = new LinkedList<>();
        ListNode slow = head;
        ListNode fast = head;

        // slow指向中点，若为奇数，就是中间那个，若为偶数，就是偏左边一个的那个
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 全给我压进去，压进去之后，queue.size() <= 左边链表节点的数量
        slow = slow.next; // 指向右半部分的链表起点
        while (slow != null) {
            queue.addLast(slow);
            slow = slow.next;
        }

        // 现在开始重组，从栈里拿出来就行
        ListNode moveNode = head;
        while (!queue.isEmpty()) {
            ListNode tmpNode = moveNode.next;
            moveNode.next = queue.pollLast();
            moveNode = moveNode.next;
            moveNode.next = tmpNode;
            moveNode = moveNode.next;
        }
        moveNode.next = null;
    }
}