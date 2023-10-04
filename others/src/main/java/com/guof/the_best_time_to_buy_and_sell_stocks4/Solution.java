package com.guof.the_best_time_to_buy_and_sell_stocks4;


import java.util.Arrays;

class Solution {
    public int maxProfit(int k, int[] prices) {
        // 第k次购买 0 手头没有，1 手头有
        int[][][] dp = new int[prices.length][2][k + 1];

        for (int i = 0; i < prices.length; i++) {
            Arrays.fill(dp[i][1], Integer.MIN_VALUE);
        }
        dp[0][0][0] = 0;
        dp[0][1][1] = -prices[0];

        for (int i = 1; i < prices.length; i++) {
            dp[i][0][0] = dp[i - 1][0][0];

            for (int j = 1; j < k + 1; j++) {
                dp[i][0][j] = Math.max(dp[i - 1][0][j], dp[i - 1][1][j] + prices[i]);
                // 手头没有的，再不济也是0
                dp[i][1][j] = Math.max(dp[i - 1][1][j], dp[i - 1][0][j - 1] - prices[i]);
            }
        }

        int output = 0;
        for (int i = 0; i < k + 1; i++) {
            output = Math.max(output, dp[prices.length - 1][0][i]);
        }

        return output;
    }
}