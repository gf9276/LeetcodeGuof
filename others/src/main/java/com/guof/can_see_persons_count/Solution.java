package com.guof.can_see_persons_count;


import java.util.*;

class Solution {
    public int[] canSeePersonsCount(int[] heights) {
        // 好像理解错了，两者之间要满足高度严格小于两者，才看得见

        int[] output = new int[heights.length]; // output 还包括到达第一个大于的值中间那一串矮子

        // 先用单调栈，找到当前右侧高度大于当前位置的点
        Deque<Integer> stack = new LinkedList<>(); // deque模拟stack

        for (int i = 0; i < heights.length; i++) {
            // 单调栈
            while (!stack.isEmpty() && heights[stack.peekFirst()] < heights[i]) {
                // 比他小的都扔出去
                output[stack.pollFirst()]++;
            }
            if (!stack.isEmpty()) {
                output[stack.peekFirst()]++;
            }
            stack.addFirst(i);
        }

        return output;
    }
}