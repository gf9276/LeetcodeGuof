package com.guof.heap_exercise_questions.topk_high_frequency_elements;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
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
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Integer[]> heap = new PriorityQueue<>((a, b) -> a[1] - b[1]); // 最小堆

        for (int num : nums) {
            // 统计数量
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (Integer key : map.keySet()) {
            // 获取所有元素
            if (heap.size() < k) {
                heap.add(new Integer[]{key, map.get(key)});
            } else {
                assert heap.peek() != null;
                if (heap.peek()[1] < map.get(key)) {
                    heap.poll();
                    heap.add(new Integer[]{key, map.get(key)});
                }
            }
        }
        int[] output = new int[k];
        for (int i = 0; i < output.length; i++) {
            output[i] = Objects.requireNonNull(heap.poll())[0];
        }
        return output;
    }
}