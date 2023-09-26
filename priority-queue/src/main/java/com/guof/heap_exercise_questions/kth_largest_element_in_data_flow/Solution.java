package com.guof.heap_exercise_questions.kth_largest_element_in_data_flow;

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
class KthLargest {
    PriorityQueue<Integer> heap;
    int maxK;

    public KthLargest(int k, int[] nums) {
        heap = new PriorityQueue<>((a, b) -> a - b); // 初始化一个最小堆
        maxK = k;
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
    }

    public int add(int val) {
        if (heap.size() < maxK) {
            heap.add(val);
        } else {
            if (heap.peek() < val) {
                heap.poll();
                heap.add(val);
            }
        }
        return heap.peek();
    }
}
