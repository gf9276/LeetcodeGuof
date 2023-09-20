package com.guof.linear_dp.single_string_problem_other_single_string_dpi_problems.bit_count;

class Solution {
    public int[] countBits(int n) {
        int[] dp = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            dp[i] = dp[i / 2] + i % 2;
        }
        return dp;
    }
}