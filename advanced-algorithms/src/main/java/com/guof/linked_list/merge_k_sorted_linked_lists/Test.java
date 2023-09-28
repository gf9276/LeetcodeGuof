package com.guof.linked_list.merge_k_sorted_linked_lists;


/**
 * ClassName: Test
 * Package: com.feng.dynamic_programming.climb_stairs
 * Description:
 *
 * @Author guof
 * @Create 2023/3/30 20:14
 * @Version 1.0
 */
public class Test {
    public static void main(String[] args) {
        Solution solu = new Solution();
        ListNode[] input = new ListNode[3];
        input[0] = new ListNode(1, new ListNode(4, new ListNode(5)));
        input[1] = new ListNode(1, new ListNode(3, new ListNode(4)));
        input[2] = new ListNode(2, new ListNode(6));
        solu.mergeKLists(input);
    }
}
