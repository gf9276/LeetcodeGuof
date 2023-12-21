package com.guof.maximum_sum_of_heights;


import java.util.*;

class Solution {
    public long maximumSumOfHeights(List<Integer> maxHeights) {
        Deque<Integer> deque = new LinkedList<>();

        // 单调栈，找到左侧比他矮的idx
        int[] left = new int[maxHeights.size()];
        Arrays.fill(left, -1);

        for (int i = left.length - 1; i >= 0; i--) {
            while (!deque.isEmpty() && maxHeights.get(i) <= maxHeights.get(deque.peekFirst())) {
                left[deque.pollFirst()] = i;
            }
            deque.addFirst(i);
        }

        int[] right = new int[maxHeights.size()];
        Arrays.fill(right, right.length);

        deque.clear();
        for (int i = 0; i < right.length; i++) {
            while (!deque.isEmpty() && maxHeights.get(i) <= maxHeights.get(deque.peekFirst())) {
                right[deque.pollFirst()] = i;
            }
            deque.addFirst(i);
        }

        long[] dpLeftHeightMax = new long[maxHeights.size()]; // 左侧最大高度
        dpLeftHeightMax[0] = 0; // 0的左侧没东西了
        for (int i = 1; i < dpLeftHeightMax.length; i++) {
            if (left[i] != -1) {
                dpLeftHeightMax[i] += dpLeftHeightMax[left[i]] + maxHeights.get(left[i]);
            }
            dpLeftHeightMax[i] += (long) (i - left[i] - 1) * maxHeights.get(i);
        }

        long[] dpRightHeightMax = new long[maxHeights.size()]; // 左侧最大高度
        dpRightHeightMax[dpRightHeightMax.length - 1] = 0; // 最右边也没有东西了
        for (int i = right.length - 2; i >= 0; i--) {
            if (right[i] != right.length) {
                dpRightHeightMax[i] += dpRightHeightMax[right[i]] + maxHeights.get(right[i]);
            }
            dpRightHeightMax[i] += (long) (right[i] - i - 1) * maxHeights.get(i);
        }

        long output = 0;

        for (int i = 0; i < maxHeights.size(); i++) {
            output = Math.max(output, maxHeights.get(i) + dpLeftHeightMax[i] + dpRightHeightMax[i]);
        }
        return output;
    }
}