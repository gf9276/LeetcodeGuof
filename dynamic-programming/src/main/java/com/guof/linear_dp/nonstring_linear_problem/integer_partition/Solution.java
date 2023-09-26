package com.guof.linear_dp.nonstring_linear_problem.integer_partition;

class Solution {
    public int integerBreak(int n) {
        // 这个子问题很明显，逐个遍历取最大值就好了，这么简单
        int[] dp = new int[n + 1];

        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;

        for (int i = 3; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(dp[i], dp[j] * (i - j));
                dp[i] = Math.max(dp[i], j * (i - j));
            }
        }
        return dp[n];
    }
}