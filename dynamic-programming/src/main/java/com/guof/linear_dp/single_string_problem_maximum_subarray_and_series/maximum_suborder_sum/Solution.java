package com.guof.linear_dp.single_string_problem_maximum_subarray_and_series.maximum_suborder_sum;

class Solution {
    public int maxSubArray(int[] nums) {
        // 当前最大和为上一个和+当前值

        int[] dp = new int[nums.length];
        dp[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
        }

        int output = nums[0];
        for (int i : dp) {
            if (i > output) {
                output = i;
            }
        }
        return output;
    }
}