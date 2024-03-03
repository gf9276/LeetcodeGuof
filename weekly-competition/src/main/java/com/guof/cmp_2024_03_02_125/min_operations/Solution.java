package com.guof.cmp_2024_03_02_125.min_operations;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

class Solution {
    public int minOperations(int[] nums, int k) {
        int output = 0;
        PriorityQueue<Long> heap = new PriorityQueue<>(); // 最小堆

        for (int num : nums) {
            heap.add((long) num);
        }

        while (heap.peek() < k) {
            output++;
            long x = heap.poll();
            long y = heap.poll();
            heap.add(Math.max(x, y) + 2 * Math.min(x, y));
        }
        return output;
    }
}