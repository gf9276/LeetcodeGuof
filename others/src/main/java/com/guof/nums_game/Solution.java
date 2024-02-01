package com.guof.nums_game;


import java.util.*;

class Solution {
    public int[] numsGame(int[] nums) {
        // 左边小，右边大
        PriorityQueue<Integer> left = new PriorityQueue<>((a, b) -> b - a);
        PriorityQueue<Integer> right = new PriorityQueue<>((a, b) -> a - b);
        long leftSum = 0;
        long rightSum = 0;

        int[] output = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            nums[i] -= i;
            // 右边多一个
            int leftSize = left.size();
            int rightSize = right.size();

            if (rightSize == leftSize) {
                if (rightSize == 0 || nums[i] > left.peek()) {
                    rightSum += nums[i];
                    right.add(nums[i]);
                } else {
                    leftSum -= left.peek();
                    leftSum += nums[i];
                    right.add(left.poll());
                    left.add(nums[i]);
                    rightSum += right.peek();
                }
            } else {
                if (nums[i] >= right.peek()) {
                    rightSum -= right.peek();
                    rightSum += nums[i];
                    left.add(right.poll());
                    right.add(nums[i]);
                    leftSum += left.peek();
                } else {
                    leftSum += nums[i];
                    left.add(nums[i]);
                }
            }

            leftSize = left.size();
            rightSize = right.size();

            if (leftSize == rightSize) {
                output[i] = (int) ((rightSum - leftSum) % 1000000007);
            } else {
                output[i] = (int) ((rightSum - leftSum - right.peek()) % 1000000007);
            }
        }
        return output;
    }
}