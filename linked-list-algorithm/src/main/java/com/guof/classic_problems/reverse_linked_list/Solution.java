package com.guof.classic_problems.reverse_linked_list;

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
    public ListNode reverseList(ListNode head) {
        ListNode output = null;
        ListNode move = head;

        while (move != null) {
            ListNode tmp = new ListNode(move.val);
            tmp.next = output;
            output = tmp;
            move = move.next;
        }
        return output;

    }
}