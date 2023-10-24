package com.guof.num_subarray_bounded_max;


import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

class Solution {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        Deque<Integer> heap = new LinkedList<>(); // 用来模拟stack

        int[] leftArr = new int[nums.length];
        int[] rightArr = new int[nums.length];

        // 先算右边的
        Arrays.fill(rightArr, nums.length - 1);
        for (int i = 0; i < nums.length; i++) {
            while (!heap.isEmpty() && nums[heap.peekLast()] < nums[i]) {
                rightArr[heap.pollLast()] = i - 1;
            }
            heap.add(i);
        }

        heap.clear();

        Arrays.fill(leftArr, 0);
        for (int i = nums.length - 1; i >= 0; i--) {
            while (!heap.isEmpty() && nums[heap.peekLast()] <= nums[i]) {
                leftArr[heap.pollLast()] = i + 1;
            }
            heap.add(i);
        }

        // 计算子数组
        int output = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= left && nums[i] <= right) {
                output += ((i - leftArr[i] + 1) * (rightArr[i] - i + 1));
            }
        }
        return output;
    }
}