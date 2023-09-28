package com.guof.linked_list.copy_a_linked_list_with_random_pointers;

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}