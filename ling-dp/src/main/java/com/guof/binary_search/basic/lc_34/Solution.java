package com.guof.binary_search.basic.lc_34;

class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[]{-1, -1};
        }
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = (right - left) / 2 + left;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        // left 肯定是第一个target
        if (left >= nums.length || nums[left] != target) {
            return new int[]{-1, -1};
        }
        // 找到头和尾
        int[] dp = new int[]{left, left};
        left = 0;
        right = nums.length;
        while (left < right) {
            int mid = (right - left) / 2 + left;
            if (nums[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        dp[1] = right - 1;
        return dp;
    }
}