package com.guof.the_largest_rectangle_in_the_bar_chart;


import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

class Solution {
    public int largestRectangleArea(int[] heights) {
        // 其实高度可以累加，然后计算每个高度下的面积最大值，这是一种方法
        // 还有一种方法就是单调栈，寻找左右比自己大的

        Deque<Integer> stack = new ArrayDeque<>();
        int[] dpLeft = new int[heights.length];
        Arrays.fill(dpLeft, 0); // 初始化最左边为0
        int[] dpRight = new int[heights.length];
        Arrays.fill(dpRight, heights.length - 1); // 初始化每一个坐标的右侧最近最高的是heights,length-1

        for (int i = 0; i < heights.length; i++) {
            while (!stack.isEmpty() && heights[stack.peekLast()] > heights[i]) {
                dpRight[stack.pollLast()] = i - 1;
            }
            stack.add(i);
        }

        for (int i = heights.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && heights[stack.peekLast()] > heights[i]) {
                dpLeft[stack.pollLast()] = i + 1;
            }
            stack.add(i);
        }

        int output = 0;
        for (int i = 0; i < heights.length; i++) {
            output = Math.max(output, (dpRight[i] - dpLeft[i] + 1) * heights[i]);
        }

        return output;
    }
}