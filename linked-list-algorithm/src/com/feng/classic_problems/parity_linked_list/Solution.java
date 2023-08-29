package com.feng.classic_problems.parity_linked_list;

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
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode oddList = head;
        ListNode evenHead = head.next;
        ListNode evenList = evenHead;

        while (true) {

            if (evenList.next == null) {
                oddList.next = evenHead;
                break;
            }
            oddList.next = evenList.next;
            oddList = oddList.next;

            if (oddList.next == null) {
                oddList.next = evenHead;
                evenList.next = null;
                break;
            }
            evenList.next = oddList.next;
            evenList = evenList.next;

        }

        return head;

    }
}