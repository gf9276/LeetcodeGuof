package com.guof.state_machine_dp.buy_and_sell_stocks.lc_188;

import java.util.Arrays;

class Solution {
    public int maxProfit(int k, int[] prices) {
        // 只有两次机会
        int[][][] dp = new int[prices.length][2][k + 1];
        Arrays.fill(dp[0][1], -prices[0]);

        for (int i = 1; i < prices.length; i++) {
            dp[i][0][0] = dp[i - 1][0][0];
            for (int j = 1; j <= k; j++) {
                dp[i][0][j] = Math.max(dp[i - 1][0][j], dp[i - 1][1][j - 1] + prices[i]);
            }

            for (int j = 0; j <= k; j++) {
                dp[i][1][j] = Math.max(dp[i - 1][1][j], dp[i - 1][0][j] - prices[i]);
            }
        }

        return Arrays.stream(dp[prices.length - 1][0]).max().getAsInt();
    }
}