package com.guof.prefix_sum_and_monotonic_stack_monotonic_queue.the_maximum_sum_of_circular_subarrays;

import java.util.PriorityQueue;

class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int n = nums.length;
        // 化环为链，题目转变为在newNums中寻找长度为n的最大和
        int[] newNums = new int[2 * n];
        System.arraycopy(nums, 0, newNums, 0, n);
        System.arraycopy(nums, 0, newNums, n, n);

        int[] prefix = new int[2 * n];
        prefix[0] = nums[0];
        for (int i = 1; i < 2 * n; i++) {
            prefix[i] = prefix[i - 1] + newNums[i];
        }

        PriorityQueue<Integer[]> priorityQueue = new PriorityQueue<>((a, b) -> a[1] - b[1]); // 最小堆


        int output = newNums[0];
        priorityQueue.add(new Integer[]{0, prefix[0]});
        for (int i = 1; i < 2 * n; i++) {
            while (i - priorityQueue.peek()[0] > n) {
                priorityQueue.poll();
            }
            output = Math.max(prefix[i] - priorityQueue.peek()[1], output);
            priorityQueue.add(new Integer[]{i, prefix[i]});
        }
        return output;
    }
}