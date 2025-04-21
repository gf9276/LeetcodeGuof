package com.guof.state_machine_dp.buy_and_sell_stocks.lc_123;

import java.util.Arrays;

class Solution {
    public int maxProfit(int[] prices) {
        // 只有两次机会
        int[][][] dp = new int[prices.length][2][3];
        dp[0][0][0] = 0;
        dp[0][1][0] = -prices[0];
        dp[0][1][1] = -prices[0];
        dp[0][1][2] = -prices[0];

        for (int i = 1; i < prices.length; i++) {
            dp[i][0][0] = dp[i - 1][0][0];
            dp[i][0][1] = Math.max(dp[i - 1][0][1], dp[i - 1][1][0] + prices[i]);
            dp[i][0][2] = Math.max(dp[i - 1][0][2], dp[i - 1][1][1] + prices[i]);

            dp[i][1][0] = Math.max(dp[i - 1][1][0], dp[i - 1][0][0] - prices[i]);
            dp[i][1][1] = Math.max(dp[i - 1][1][1], dp[i - 1][0][1] - prices[i]);
            dp[i][1][2] = Math.max(dp[i - 1][1][2], dp[i - 1][0][2] - prices[i]);
        }

        return Arrays.stream(dp[prices.length - 1][0]).max().getAsInt();
    }
}