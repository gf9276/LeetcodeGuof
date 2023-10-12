package com.guof.cnt_the_number_of_fair_number_pairs;


import java.util.Arrays;

class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        // 可以用前缀和，但是前缀和得配合二分法，有难度啊，所以直接用二分吧
        Arrays.sort(nums); // 排序一下

        long output = 0;

        // 找左边界，找右边界
        for (int i = 0; i < nums.length - 1; i++) {
            int left = i + 1;
            int right = nums.length;
            int curLower = lower - nums[i];
            int curUpper = upper - nums[i];
            int lowerIdx;
            int upperIdx;

            while (left < right) {
                // left < right 区间就是[left, right)，左闭又开
                int mid = (right - left) / 2 + left;

                if (nums[mid] < curLower) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            lowerIdx = left;

            left = i + 1;
            right = nums.length;
            while (left < right) {
                // left < right 区间就是[left, right)，左闭又开
                int mid = (right - left) / 2 + left;

                if (nums[mid] <= curUpper) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            upperIdx = left;

            output += upperIdx - lowerIdx;
        }

        return output;
    }
}