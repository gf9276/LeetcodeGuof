package com.feng.classic_problems.remove_linked_list_elements;

/**
 * ClassName: Solution
 * Package: com.feng.arrays_and_strings.letter_heterotopic_word_grouping
 * Description:
 * 写的不好，年纪大了，唉
 * 想我大二那会儿，真是悲哀
 *
 * @Author guof
 * @Create 2023/4/4 18:41
 * @Version 1.0
 */

/**
 * Definition for singly-linked list.
 * class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 */
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }

        while (head != null && head.val == val) {
            head = head.next;
        }

        ListNode move = head;
        ListNode beforeMove = new ListNode(-1);
        beforeMove.next = move;

        while (move != null) {
            if (move.val == val) {
                beforeMove.next = move.next;
            } else {
                beforeMove = beforeMove.next;
            }
            move = move.next;
        }
        return head;
    }
}