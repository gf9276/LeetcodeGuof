package com.guof.package_dp.zero_one.lc_279;

import java.util.Arrays;

class Solution {
    public int numSquares(int n) {
        // n 是10的四次
        int[] dp = new int[n + 1];
        Arrays.fill(dp, 0x3f3f3f3f);
        dp[0] = 0;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }
}