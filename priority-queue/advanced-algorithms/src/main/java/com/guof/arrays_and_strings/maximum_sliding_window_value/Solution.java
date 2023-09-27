package com.guof.arrays_and_strings.maximum_sliding_window_value;

import java.util.*;

/**
 * ClassName: Solution
 * Package: com.feng.dynamic_programming.climb_stairs
 * Description:
 *
 * @Author guof
 * @Create 2023/3/27 22:23
 * @Version 1.0
 */
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer[]> heap = new PriorityQueue<>((a, b) -> b[1] - a[1]); // 最大堆

        for (int i = 0; i < k; i++) {
            heap.add(new Integer[]{i, nums[i]});
        }

        int[] output = new int[nums.length - k + 1];
        output[0] = heap.peek()[1];
        for (int right = k; right < nums.length; right++) {
            int left = right - (k - 1);
            heap.add(new Integer[]{right, nums[right]});
            while (heap.peek()[0] < left) {
                heap.poll();
            }
            output[left] = heap.peek()[1];
        }

        return output;
    }
}