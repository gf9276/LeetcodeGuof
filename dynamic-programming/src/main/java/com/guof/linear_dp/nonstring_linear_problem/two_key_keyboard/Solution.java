package com.guof.linear_dp.nonstring_linear_problem.two_key_keyboard;

import java.util.Arrays;

class Solution {
    public int minSteps(int n) {
        if (n == 1) {
            return 0;
        }
        // 复制内容为空的情况直接忽视
        int[][] dp = new int[n][n];
        for (int[] ints : dp) {
            Arrays.fill(ints, Integer.MAX_VALUE);
        }
        dp[0][0] = 1; // 有一个A且复制内容为1个A的操作次数

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                dp[i][j] = Math.min(dp[i][j], dp[i - j - 1][j] != Integer.MAX_VALUE ? dp[i - j - 1][j] + 1 : Integer.MAX_VALUE);
                dp[i][i] = Math.min(dp[i][j] != Integer.MAX_VALUE ? dp[i][j] + 1 : Integer.MAX_VALUE, dp[i][i]); //  i == j 不就是多了一步嘛
            }
        }

        return Arrays.stream(dp[n - 1]).min().getAsInt();
    }
}