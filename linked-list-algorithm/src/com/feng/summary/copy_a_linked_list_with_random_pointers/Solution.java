package com.feng.summary.copy_a_linked_list_with_random_pointers;


import java.util.HashMap;
import java.util.Map;

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return null;

        Node move = head;
        Map<Node, Node> map = new HashMap<>();

        while (move != null) {
            map.put(move, new Node(move.val));
            move = move.next;
        }


        for (Node key : map.keySet()) {
            map.get(key).next = map.get(key.next);
            map.get(key).random = map.get(key.random);
        }

        return map.get(head);

    }
}