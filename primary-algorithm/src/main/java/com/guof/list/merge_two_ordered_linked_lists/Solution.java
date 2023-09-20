package com.guof.list.merge_two_ordered_linked_lists;

/**
 * ClassName: Solution
 * Package: com.feng.merge_two_ordered_linked_lists
 * Description:
 *
 * @Author guof
 * @Create 2023/3/25 19:03
 * @Version 1.0
 */
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        int i = 0;
        int j = 0;
        ListNode my_list = null;
        ListNode my_list_head = null;
        if (list1 == null) {
            my_list_head = my_list = list2;
            return my_list_head;
        } else if (list2 == null) {
            my_list_head = my_list = list1;
            return my_list_head;
        }

        // 获取头
        if (list1.val > list2.val) {
            my_list_head = my_list = list2;
            list2 = list2.next;
        } else {
            my_list_head = my_list = list1;
            list1 = list1.next;
        }

        for (; ; ) {
            if (list1 == null) {
                my_list.next = list2;
                break;
            } else if (list2 == null) {
                my_list.next = list1;
                break;
            }
            if (list1.val > list2.val) {
                my_list.next = list2;
                list2 = list2.next;
            } else {
                my_list.next = list1;
                list1 = list1.next;
            }
            my_list = my_list.next;

        }
        return my_list_head;
    }
}