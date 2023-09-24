package com.guof.linear_dp.matrix_problem_matrix_dp_ij.min_path_and;

import java.util.Arrays;

class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        dp[0][0] = grid[0][0];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }

                if (j > 0 && dp[i][j - 1] != Integer.MAX_VALUE && dp[i][j - 1] + grid[i][j] < dp[i][j]) {
                    dp[i][j] = dp[i][j - 1] + grid[i][j];
                }
                if (i > 0 && dp[i - 1][j] != Integer.MAX_VALUE && dp[i - 1][j] + grid[i][j] < dp[i][j]) {
                    dp[i][j] = dp[i - 1][j] + grid[i][j];
                }
            }
        }
        return dp[m - 1][n - 1];
    }
}