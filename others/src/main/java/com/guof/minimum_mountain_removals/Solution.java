package com.guof.minimum_mountain_removals;


import java.util.*;

class Solution {

    public int minimumMountainRemovals(int[] nums) {
        Deque<Integer> deque = new LinkedList<>();

        // 单调栈，找到左侧比他矮的idx
        int[] left = new int[nums.length];
        Arrays.fill(left, -1);

        for (int i = left.length - 1; i >= 0; i--) {
            while (!deque.isEmpty() && nums[i] < nums[deque.peekFirst()]) {
                left[deque.pollFirst()] = i;
            }
            deque.addFirst(i);
        }

        int[] right = new int[nums.length];
        Arrays.fill(right, right.length);

        deque.clear();
        for (int i = 0; i < right.length; i++) {
            while (!deque.isEmpty() && nums[i] < nums[deque.peekFirst()]) {
                right[deque.pollFirst()] = i;
            }
            deque.addFirst(i);
        }

        int output = 0x3f3f3f3f;

        int[] dpLeft = new int[nums.length];
        dpLeft[0] = 0; // 不需要删除
        for (int i = 1; i < nums.length; i++) {
            dpLeft[i] = i; // 初始默认全删了
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dpLeft[i] = Math.min(dpLeft[i], dpLeft[j] + i - j - 1); // 中间全删掉
                }
            }
        }

        int[] dpRight = new int[nums.length];
        dpRight[dpRight.length - 1] = 0; // 最右边不需要删除
        for (int i = dpRight.length - 2; i >= 0; i--) {
            dpRight[i] = dpRight.length - i - 1;
            for (int j = dpRight.length - 1; j > i; j--) {
                if (nums[j] < nums[i]) {
                    dpRight[i] = Math.min(dpRight[i], dpRight[j] + j - i - 1); // 中间全删掉
                }
            }
        }

        for (int i = 1; i < nums.length - 1; i++) {
            if (dpLeft[i] == i) {
                // 全删了，不行
                continue;
            }
            if (dpRight[i] == dpRight.length - i - 1) {
                // 全删了，不行
                continue;
            }
            output = Math.min(output, dpRight[i] + dpLeft[i]);
        }
        return output;
    }
}