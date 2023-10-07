package com.guof.one_dimensional_prefix_and.region_and_retrieval_array_immutable;


class NumArray {
    int[] dp;

    public NumArray(int[] nums) {
        dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = dp[i - 1] + nums[i];
        }
    }

    public int sumRange(int left, int right) {
        return dp[right] - ((left - 1 >= 0) ? dp[left - 1] : 0);
    }
}