package com.guof.linear_dp.backpack_dp.profit_plan;

class Solution {
    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        int mod = (int) 1e9 + 7; // 用来取余数的

        // ？件物品  ？个员工数  ？最小利润
        int[][][] dp = new int[profit.length + 1][n + 1][minProfit + 1];
        for (int i = 0; i <= n; i++) {
            dp[0][i][0] = 1;
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                for (int k = 0; k < dp[i][j].length; k++) {
                    dp[i][j][k] = dp[i - 1][j][k];
                    if (j - group[i - 1] >= 0) {
                        dp[i][j][k] += dp[i - 1][j - group[i - 1]][Math.max(0, k - profit[i - 1])];
                    }
                    dp[i][j][k] %= mod;
                }
            }
        }
        return dp[profit.length][n][minProfit];
    }
}