package com.guof.dp.the_best_time_to_buy_and_sell_stocks_including_freeze_period;

class Solution {
    public int maxProfit(int[] prices) {
        // 0 有股票 1 没股票且不在冷冻期 2 没股票且在冷冻期
        int[][] dp = new int[prices.length][3];
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        dp[0][2] = 0;

        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][1] - prices[i], dp[i - 1][0]);

            dp[i][1] = Math.max(dp[i - 1][2], dp[i - 1][1]);

            dp[i][2] = dp[i - 1][0] + prices[i];
        }

        return Math.max(dp[prices.length - 1][1], dp[prices.length - 1][2]);
    }
}