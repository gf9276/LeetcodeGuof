package com.guof.october222023_368.elements_and_the_smallest_mountain_triple1;


import java.util.*;

class Solution {
    public int minimumSum(int[] nums) {
        // 记录一个值，左侧比他小的最小值
        PriorityQueue<Integer> heap = new PriorityQueue<>(); // 最小堆

        int[] left = new int[nums.length]; // 0和最后一个是没用的
        heap.clear();
        heap.add(nums[0]);
        for (int i = 1; i < left.length; i++) {
            left[i] = heap.peek();
            heap.add(nums[i]);
        }

        int[] right = new int[nums.length];
        heap.clear();
        heap.add(nums[nums.length - 1]);
        for (int i = right.length - 2; i >= 0; i--) {
            right[i] = heap.peek();
            heap.add(nums[i]);
        }

        int output = Integer.MAX_VALUE;

        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i] > left[i] && nums[i] > right[i]) {
                output = Math.min(output, nums[i] + left[i] + right[i]);
            }
        }

        return output == Integer.MAX_VALUE ? -1 : output;
    }
}