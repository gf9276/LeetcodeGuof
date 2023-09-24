package com.guof.linear_dp.matrix_problem_matrix_dp_ij.dungeon_game;

class Solution {
    public int calculateMinimumHP(int[][] grid) {
        // 我的评价是，不如直接设置一个初始生命值，随便他造，tmd

        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];

        // 倒着来
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i == m - 1 && j == n - 1) {
                    dp[i][j] = Math.max(1 - grid[m - 1][n - 1], 1);
                } else if (i == m - 1) {
                    dp[i][j] = Math.max(dp[i][j + 1] - grid[i][j], 1);
                } else if (j == n - 1) {
                    dp[i][j] = Math.max(dp[i + 1][j] - grid[i][j], 1);
                } else {
                    dp[i][j] = Math.max(Math.min(dp[i][j + 1], dp[i + 1][j]) - grid[i][j], 1);
                }
            }
        }
        return dp[0][0];
    }
}