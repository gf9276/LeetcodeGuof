package com.guof.max_area;


import java.util.Deque;
import java.util.LinkedList;

class Solution {
    public int maxArea(int[] height) {
        // 写个单调栈，放松一下
        // 这题目其实就是遍历，找每个柱子，左边比他高和右边比他高的柱子的idx
        Deque<Integer> stack = new LinkedList<>(); // 用双向队列来模拟栈，这个效率更高

        int[] leftArr = new int[height.length];
        int[] rightArr = new int[height.length];

        stack.clear();
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[i] >= height[stack.peekFirst()]) {
                stack.pollFirst();
            }
            leftArr[i] = !stack.isEmpty() ? stack.peekFirst() : i - 1;
            stack.addFirst(i);
        }
        stack.clear();
        for (int i = height.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && height[i] >= height[stack.peekFirst()]) {
                stack.pollFirst();
            }
            rightArr[i] = !stack.isEmpty() ? stack.peekFirst() : i + 1;
            stack.addFirst(i);
        }

        // 获取当前右边比他大的idx和左边比他大的idx
        int output = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            output = Math.max((right - left) * Math.min(height[right], height[left]), output);
            if (height[right] < height[left]) {
                // 尝试优化短板
                right = leftArr[right];
            } else {
                left = rightArr[left];
            }
        }

        return output;
    }
}