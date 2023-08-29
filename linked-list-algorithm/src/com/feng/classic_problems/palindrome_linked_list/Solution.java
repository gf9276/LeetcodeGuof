package com.feng.classic_problems.palindrome_linked_list;

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

import java.util.Stack;

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
    public boolean isPalindrome(ListNode head) {
        if (head.next == null) return true;

        ListNode slow = head;
        ListNode fast = head;
        Stack<Integer> stack = new Stack<>();

        while (fast != null && fast.next != null) {
            stack.push(slow.val);
            slow = slow.next;
            if (fast.next != null) {
                fast = fast.next.next;
            } else {
                break;
            }
        }

        if (fast != null) slow = slow.next;

        while (slow != null) {
            if (stack.pop() != slow.val) {
                return false;
            }
            slow = slow.next;
        }

        return true;
    }
}