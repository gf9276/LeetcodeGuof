package com.feng.double_pointer_technique.circular_linked_list2;

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
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast!=null) {
            if (slow.next != null) {
                slow = slow.next;
            } else {
                break;
            }

            if (fast.next != null && fast.next.next != null) {
                fast = fast.next.next;
            } else {
                break;
            }

            if (slow.equals(fast)) {
                ListNode anotherHead = head;
                while (true) {
                    if (anotherHead.equals(slow)) {
                        return slow;
                    } else {
                        slow = slow.next;
                        anotherHead = anotherHead.next;
                    }
                }
            }
        }

        return null;
    }
}