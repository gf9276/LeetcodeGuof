package com.guof.list.intersecting_linked_list;

/**
 * ClassName: Solution
 * Package: com.feng.list.intersecting_linked_list
 * Description:
 *
 * @Author guof
 * @Create 2023/4/6 16:09
 * @Version 1.0
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // 集合的方法都能想到，但是空间复杂度就是o(n)了，所以换一种
        int aLen = 0;
        int bLen = 0;
        ListNode listA = headA;
        ListNode listB = headB;
        while (listA != null) {
            aLen++;
            listA = listA.next;
        }
        while (listB != null) {
            bLen++;
            listB = listB.next;
        }

        listA = headA;
        listB = headB;
        while (aLen > bLen) {
            listA = listA.next;
            aLen--;
        }
        while (bLen > aLen) {
            listB = listB.next;
            bLen--;
        }

        while (aLen > 0) {
            if (listB == listA) {
                return listB;
            }
            listB = listB.next;
            listA = listA.next;
            aLen--;
        }

        return null;
    }
}