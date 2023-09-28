package com.guof.linked_list.copy_a_linked_list_with_random_pointers;

import java.util.*;

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
    public Node copyRandomList(Node head) {
        Node move = head;
        Map<Node, Node> map = new HashMap<>();
        while (move != null) {
            map.put(move, new Node(move.val));
            move = move.next;
        }
        move = head;
        while (move != null) {
            map.get(move).next = map.get(move.next);
            map.get(move).random = map.get(move.random);
            move = move.next;
        }

        return map.get(head);
    }
}