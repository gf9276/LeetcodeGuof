package com.guof.others.the_largest_rectangle_in_the_bar_chart;

class Solution {
    public int largestRectangleArea(int[] heights) {
        // 用dp优化一下
        int[] dpLeft = new int[heights.length];
        int[] dpRight = new int[heights.length];
        // 边界条件
        dpLeft[0] = 0;
        dpRight[heights.length - 1] = heights.length - 1;

        // 寻找左边的最高的柱子的下角标
        for (int i = 1; i < heights.length; i++) {
            int left = i; // 从i开始扩散
            if (heights[i - 1] >= heights[i]) {
                // 如果前一个比当前的高度大，直接就可以继承
                left = dpLeft[i - 1]; // 继承
                // 再扩散
                while (left > 0 && heights[left - 1] >= heights[i]) {
                    left--;
                }
            }
            dpLeft[i] = left;
        }

        // 寻找右边的最高的柱子的下角标
        for (int i = heights.length - 2; i >= 0; i--) {
            int right = i; // 从i开始扩散
            if (heights[i + 1] >= heights[i]) {
                // 如果后一个比当前的高度大，直接就可以继承
                right = dpRight[i + 1]; // 继承
                // 再扩散
                while (right < heights.length - 1 && heights[right + 1] >= heights[i]) {
                    right++;
                }
            }
            dpRight[i] = right;
        }


        int output = Integer.MIN_VALUE;
        for (int i = 0; i < heights.length; i++) {
            if (i < heights.length - 1 && heights[i] == heights[i + 1]) {
                // 同样高度的，只用计算一次
                continue;
            }
            // 计算面积，高*宽
            int curHeight = heights[i];
            int left = dpLeft[i];
            int right = dpRight[i];
            output = Math.max(output, curHeight * (right - left + 1));
        }
        return output;
    }
}