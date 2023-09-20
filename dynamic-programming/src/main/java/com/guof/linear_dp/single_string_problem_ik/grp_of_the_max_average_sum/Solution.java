package com.guof.linear_dp.single_string_problem_ik.grp_of_the_max_average_sum;

import java.util.Arrays;

class Solution {
    public double largestSumOfAverages(int[] nums, int k) {
        // 前n个，分k个数组
        double[][] dp = new double[nums.length + 1][k + 1];
        dp[0][0] = 0;
        Arrays.fill(dp[1], nums[0]);
        dp[1][0] = 0;
        // 前j个，分k-1次
        for (int i = 1; i < nums.length + 1; i++) {
            for (int l = 0; l < i; l++) {
                for (int j = 1; j < k + 1; j++) {
                    double tmp;
                    if (j == 1) {
                        tmp = (double) Arrays.stream(Arrays.copyOfRange(nums, 0, i)).sum() / i;
                    } else {
                        tmp = dp[l][j - 1] + (double) Arrays.stream(Arrays.copyOfRange(nums, l, i)).sum() / (i - l);
                    }
                    dp[i][j] = Math.max(dp[i][j], tmp);
                }
            }
        }
        return dp[nums.length][k];
    }
}