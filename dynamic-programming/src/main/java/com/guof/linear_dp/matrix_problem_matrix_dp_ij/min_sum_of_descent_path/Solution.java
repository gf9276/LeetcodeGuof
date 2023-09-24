package com.guof.linear_dp.matrix_problem_matrix_dp_ij.min_sum_of_descent_path;

import java.util.Arrays;

class Solution {
    public int minFallingPathSum(int[][] matrix) {
        // 不是有手就行？
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];

        for (int i = 1; i < m; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        dp[0] = Arrays.copyOf(matrix[0], n); // 第0行，直接就是matrix的值

        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = Math.min(dp[i][j], dp[i - 1][j]);
                if (j > 0) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1]);
                }
                if (j < n - 1) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j + 1]);
                }
                dp[i][j] += matrix[i][j];
            }
        }

        return Arrays.stream(dp[m - 1]).min().getAsInt();
    }
}