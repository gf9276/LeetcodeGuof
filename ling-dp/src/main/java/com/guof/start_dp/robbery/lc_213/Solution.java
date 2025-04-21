package com.guof.start_dp.robbery.lc_213;


// leetcode 198
// 打家劫舍

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        // 既然是一个圈，那就别投第一个被
        int[] dp = new int[nums.length + 1];
        dp[1] = 0;
        dp[0] = 0;
        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i - 1], dp[i - 1]);
        }
        int ans1 = dp[dp.length - 1];

        Arrays.fill(dp, 0);
        dp[0] = 0;
        dp[1] = nums[0]; // 偷盗第一家

        for (int i = 2; i < dp.length - 1; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i - 1], dp[i - 1]);
        }
        int ans2 = dp[dp.length - 2];

        return Math.max(ans1, ans2);
    }
}