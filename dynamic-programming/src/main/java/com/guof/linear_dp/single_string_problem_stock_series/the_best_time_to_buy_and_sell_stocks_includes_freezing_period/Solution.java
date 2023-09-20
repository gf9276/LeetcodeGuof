package com.guof.linear_dp.single_string_problem_stock_series.the_best_time_to_buy_and_sell_stocks_includes_freezing_period;

class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        // 多一个维度决定是否卖出
        int[][] dp = new int[prices.length][3]; // 天数，无，有，冷却
        boolean[][] dp2 = new boolean[prices.length][2];
        for (int[] ints : dp) {
            ints[1] = Integer.MIN_VALUE;
        }
        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        for (int i = 1; i < dp.length; i++) {
            dp[i][2] = dp[i - 1][1] + prices[i];
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2]);
            dp[i][1] = Math.max(dp[i - 1][0] - prices[i], dp[i - 1][1]);
        }

        int output = 0;
        for (int j = 0; j <= 2; j++) {
            output = Math.max(output, dp[dp.length - 1][j]);
        }
        return output;
    }
}