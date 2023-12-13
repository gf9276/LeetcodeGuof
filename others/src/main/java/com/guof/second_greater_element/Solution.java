package com.guof.second_greater_element;


import java.util.*;

class Solution {
    public int[] secondGreaterElement(int[] nums) {
        int[] right = new int[nums.length];

        Deque<Integer> stack1 = new LinkedList<>();
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> (a[1] - b[1])); // 最小堆
        Arrays.fill(right, -1);

        for (int i = 0; i < right.length; i++) {
            // 这个堆肯定是递减的
            while (!heap.isEmpty() && nums[heap.peek()[0]] < nums[i]) {
                right[heap.poll()[0]] = nums[i];
            }
            while (!stack1.isEmpty() && nums[stack1.peekFirst()] < nums[i]) {
                heap.add(new int[]{stack1.peekFirst(), nums[stack1.pollFirst()]}); // 进入第二阶段
            }
            stack1.addFirst(i);
        }

        return right;
    }
}