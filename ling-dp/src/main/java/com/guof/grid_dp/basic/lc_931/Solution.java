package com.guof.grid_dp.basic.lc_931;

import java.util.Arrays;

class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0) {
                    dp[i][j] = matrix[i][j];
                } else {
                    dp[i][j] = dp[i - 1][j] + matrix[i][j];
                    if (j - 1 >= 0) {
                        dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1] + matrix[i][j]);
                    }
                    if (j + 1 < n) {
                        dp[i][j] = Math.min(dp[i][j], dp[i - 1][j + 1] + matrix[i][j]);
                    }
                }
            }
        }
        return Arrays.stream(dp[m - 1]).min().getAsInt();
    }
}