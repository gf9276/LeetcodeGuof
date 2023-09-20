package com.guof.linear_dp.single_string_problem_stock_series.the_best_time_to_buy_and_sell_stocks4;

import java.util.Arrays;

class Solution {
    public int maxProfit(int k, int[] prices) {
        // 两次倒也方便，前n天进行一次交易的最大值，加上未来的交易的最大值
        if (prices.length <= 1) {
            return 0;
        }

        int[][][] dp = new int[prices.length][2][k + 1]; // 天数, 手头有无, 买卖次数
        for (int[][] ints : dp) {
            Arrays.fill(ints[1], Integer.MIN_VALUE);
        }
        dp[0][0][0] = 0;
        dp[0][1][1] = -prices[0];

        for (int i = 1; i < dp.length; i++) {
            dp[i][0][0] = dp[i - 1][0][0];

            for (int j = 1; j <= k; j++) {
                dp[i][0][j] = Math.max(dp[i - 1][1][j] + prices[i], dp[i - 1][0][j]);
            }

            for (int j = 1; j <= k; j++) {
                dp[i][1][j] = Math.max(dp[i - 1][0][j - 1] - prices[i], dp[i - 1][1][j]);
            }
        }

        int output = 0;
        for (int j = 1; j <= k; j++) {
            output = Math.max(output, dp[dp.length - 1][0][j]);
        }
        return output;
    }
}