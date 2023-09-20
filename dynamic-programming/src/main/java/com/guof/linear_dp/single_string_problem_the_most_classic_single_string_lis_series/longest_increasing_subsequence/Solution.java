package com.guof.linear_dp.single_string_problem_the_most_classic_single_string_lis_series.longest_increasing_subsequence;

import java.util.Arrays;

class Solution {
    public int lengthOfLIS(int[] nums) {

        if (nums.length <= 1) {
            return 1;
        }

        int maxLength = 1;

        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j <= i; j++) {
                if (nums[i] > nums[i - j]) {
                    dp[i] = Math.max(dp[i], dp[i - j] + 1);
                    maxLength = Math.max(dp[i], maxLength);
                }
            }
        }

        return maxLength;
    }
}