package com.guof.prefix_and_optimized_dp.new_21_game;

class Solution {
    public double new21Game(int n, int k, int maxPts) {
        if (n >= k + maxPts) {
            return 1;
        }
        double[] dp = new double[k + maxPts]; // 基础分数为i时，成功的概率，最高分是k+maxPts-1

        for (int i = k; i <= Math.min(n, dp.length - 1); i++) {
            dp[i] = 1;
        }

        // 从k-1分开始
        for (int i = k - 1; i >= 0; i--) {
            double sum = 0;
            for (int j = i + 1; j <= i + maxPts; j++) {
                sum += dp[j];
            }
            dp[i] = sum / maxPts;
        }

        return dp[0];
    }
}