package com.guof.list.delete_nodes_in_the_linked_list;

class Solution {
    public void deleteNode(ListNode node) {

        node.val = node.next.val;
        node.next = node.next.next;
    }
}

