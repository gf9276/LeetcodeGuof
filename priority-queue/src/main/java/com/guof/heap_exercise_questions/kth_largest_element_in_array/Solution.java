package com.guof.heap_exercise_questions.kth_largest_element_in_array;

import java.util.PriorityQueue;

/**
 * ClassName: Solution
 * Package: com.feng.string.count_and_say_seq
 * Description:
 *
 * @Author guof
 * @Create 2023/3/24 17:26
 * @Version 1.0
 */
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> a - b); // 最小堆

        for (int i : nums) {
            if (heap.size() < k) {
                heap.add(i);
            } else {
                if (heap.peek() < i) {
                    heap.poll();
                    heap.add(i);
                }
            }
        }
        return heap.peek();
    }
}