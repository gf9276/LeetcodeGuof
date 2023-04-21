package com.feng.sort_and_search.top_k_high_frequency_elements;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.PriorityQueue;

/**
 * ClassName: Solution
 * Package: com.feng.sort_and_search.top_k_high_frequency_elements
 * Description:
 *
 * @Author guof
 * @Create 2023/4/18 14:21
 * @Version 1.0
 */
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] output = new int[k];

        Map<Integer, Integer> cntMap = new HashMap<>();

        for (int num : nums) {
            cntMap.put(num, cntMap.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a, b) -> b[1] - a[1]); // 最大堆

        for (int key : cntMap.keySet()) {
            priorityQueue.add(new int[]{key, cntMap.get(key)});
        }

        for (int i = 0; i < k; i++) {
            output[i] = Objects.requireNonNull(priorityQueue.poll())[0];
        }
        return output;
    }
}
