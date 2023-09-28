package com.guof.linked_list.merge_k_sorted_linked_lists;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * ClassName: Solution
 * Package: com.feng.dynamic_programming.climb_stairs
 * Description:
 *
 * @Author guof
 * @Create 2023/3/27 22:23
 * @Version 1.0
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        Queue<ListNode> queue = new LinkedList<>(Arrays.asList(lists));
        while (queue.size() > 1) {
            queue.add(merge2Lists(queue.poll(), queue.poll()));
        }
        return queue.poll();
    }

    public ListNode merge2Lists(ListNode node1, ListNode node2) {
        // merge两个有序链表
        ListNode move = new ListNode();
        ListNode output = move;

        while (true) {
            if (node1 == null) {
                move.next = node2;
                break;
            } else if (node2 == null) {
                move.next = node1;
                break;
            }

            if (node1.val <= node2.val) {
                move.next = node1;
                node1 = node1.next;
            } else {
                move.next = node2;
                node2 = node2.next;
            }
            move = move.next;

        }
        return output.next;
    }

}