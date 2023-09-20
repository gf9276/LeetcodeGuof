package com.guof.linear_dp.single_string_problem_stock_series.the_best_time_to_buy_and_sell_stocks_includes_handling_fees;

class Solution {
    public int maxProfit(int[] prices, int fee) {
        if (prices.length == 0) {
            return 0;
        }
        // 多一个维度决定是否卖出
        int[][] dp = new int[prices.length][2]; // 0 表示手头没有，1 表示手头还有，值表示目前利润
        dp[0][0] = 0;
        dp[0][1] = -prices[0] - fee;

        for (int i = 1; i < dp.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], prices[i] + dp[i - 1][1]);
            dp[i][1] = Math.max(dp[i - 1][0] - prices[i] - fee, dp[i - 1][1]);
        }

        return Math.max(dp[dp.length - 1][0], dp[dp.length - 1][1]);
    }
}