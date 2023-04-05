package com.feng.list.parity_linked_list;

/**
 * ClassName: Solution
 * Package: com.feng.list.parity_linked_list
 * Description:
 *
 * @Author guof
 * @Create 2023/4/5 21:26
 * @Version 1.0
 */
class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode oddMove = head;
        ListNode evenMove = head.next;
        ListNode evenHead = head.next;

        while (true) {

            if (oddMove.next != null && oddMove.next.next != null) {
                oddMove.next = oddMove.next.next;
                oddMove = oddMove.next;
            }
            if (evenMove.next != null && evenMove.next.next != null) {
                evenMove.next = evenMove.next.next;
                evenMove = evenMove.next;
            }
            if ((oddMove.next == null || oddMove.next.next == null) && (evenMove.next == null || evenMove.next.next == null)) {
                break;
            }

        }

        oddMove.next = evenHead;
        evenMove.next = null;
        return head;
    }
}