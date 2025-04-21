package com.guof.start_dp.robbery.lc_198;


// leetcode 198
// 打家劫舍

class Solution {
    public int rob(int[] nums) {
        // 不连续偷盗
        int[] dp = new int[nums.length + 1];

        dp[0] = 0; // 一家都没有偷盗
        dp[1] = nums[0];// 偷了一家
        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
        }
        return dp[dp.length - 1];
    }
}