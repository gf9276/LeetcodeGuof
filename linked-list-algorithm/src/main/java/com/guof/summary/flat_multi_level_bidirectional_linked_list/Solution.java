package com.guof.summary.flat_multi_level_bidirectional_linked_list;


class Solution {
    public Node flatten(Node head) {
        ergodic(head);
        return head;
    }

    public Node ergodic(Node head) {
        Node move = head;

        while (move != null) {
            if (move.child != null) {
                Node tmp = ergodic(move.child);


                tmp.next = move.next;
                if (tmp.next != null) {
                    move.next.prev = tmp;
                }

                move.next = move.child;
                move.child.prev = move;
                move.child = null;

                if (tmp.next == null) return tmp;

                move = tmp.next;
            } else {
                if (move.next == null) return move;
                move = move.next;
            }
        }

        return null;
    }
}