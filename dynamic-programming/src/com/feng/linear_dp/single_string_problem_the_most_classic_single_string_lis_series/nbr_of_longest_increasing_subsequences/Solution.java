package com.feng.linear_dp.single_string_problem_the_most_classic_single_string_lis_series.nbr_of_longest_increasing_subsequences;

import java.util.Arrays;

class Solution {
    public int findNumberOfLIS(int[] nums) {

        if (nums.length <= 1) {
            return 1;
        }

        int[] cnt = new int[nums.length];
        Arrays.fill(cnt, 1);
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j <= i; j++) {
                if (nums[i] > nums[i - j]) {
                    if (dp[i - j] + 1 > dp[i]) {
                        dp[i] = dp[i - j] + 1;
                        cnt[i] = cnt[i - j];
                    } else if (dp[i - j] + 1 == dp[i]) {
                        cnt[i] += cnt[i - j];
                    }
                }
            }
        }

        int longest = 0, ans = 0;
        for (int length : dp) {
            longest = Math.max(longest, length);
        }
        for (int i = 0; i < nums.length; ++i) {
            if (dp[i] == longest) {
                ans += cnt[i];
            }
        }
        return ans;
    }
}