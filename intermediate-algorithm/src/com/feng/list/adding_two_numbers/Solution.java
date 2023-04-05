package com.feng.list.adding_two_numbers;

/**
 * ClassName: Solution
 * Package: com.feng.list.adding_two_numbers
 * Description:
 *
 * @Author guof
 * @Create 2023/4/5 21:02
 * @Version 1.0
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode output = new ListNode();
        ListNode move = output;
        move.val = 0;
        int add = 0;
        while (true) {
            if (l1 != null) {
                move.val += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                move.val += l2.val;
                l2 = l2.next;
            }
            add = move.val / 10;
            move.val = move.val % 10;

            if (l1 == null && l2 == null && add == 0) {
                break;
            }

            move.next = new ListNode();
            move = move.next;
            move.val = add;
        }
        return output;
    }
}