package com.guof.classical_linear_dp.lis.lc_300;

import java.util.Arrays;

class Solution {
    public int lengthOfLIS(int[] nums) {
        // 找到最长得递增子序列
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] > nums[i]) {
                    dp[j] = Math.max(dp[j], dp[i] + 1);
                }
            }
        }
        return Arrays.stream(dp).max().getAsInt();
    }
}
