package com.guof.split_soup;


import java.util.Arrays;

class Solution {
    public double soupServings(int n) {
        if (n % 25 != 0) {
            n = (n + 25) / 25 * 25;
        } // 变成25的倍数好了，方便

        int k = n / 25; // 几个25
        k = Math.min(200, k);

        double output = 0;
        double[][] dp = new double[k + 1][k + 1];

        // 先计算同时分完的概率
        Arrays.fill(dp[0], 1);
        dp[0][0] = 0.5;

        for (int i = 1; i < k + 1; i += 1) {
            for (int j = 1; j < k + 1; j += 1) {
                dp[i][j] += 0.25 * dp[(Math.max(i - 4, 0))][j];
                dp[i][j] += 0.25 * dp[(Math.max(i - 3, 0))][Math.max(0, j - 1)];
                dp[i][j] += 0.25 * dp[(Math.max(i - 2, 0))][Math.max(0, j - 2)];
                dp[i][j] += 0.25 * dp[(Math.max(i - 1, 0))][Math.max(0, j - 3)];
            }
        }

        return  dp[k][k];
    }
}