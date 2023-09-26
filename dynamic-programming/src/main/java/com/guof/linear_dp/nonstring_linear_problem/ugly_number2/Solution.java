package com.guof.linear_dp.nonstring_linear_problem.ugly_number2;

import java.util.Arrays;

class Solution {
    public int nthUglyNumber(int n) {
        if (n <= 6) {
            return n;
        }
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[1] = 1;

        int p1 = 1;
        int p2 = 1;
        int p3 = 1;
        for (int i = 2; i < n + 1; i++) {
            dp[i] = dp[p1] * 2;
            dp[i] = Math.min(dp[i], dp[p2] * 3);
            dp[i] = Math.min(dp[i], dp[p3] * 5);

            if (dp[i] == dp[p1] * 2) {
                p1++;
            }
            if (dp[i] == dp[p2] * 3) {
                p2++;
            }
            if (dp[i] == dp[p3] * 5) {
                p3++;
            }
        }
        return dp[n];
    }
}