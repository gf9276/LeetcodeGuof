package com.guof.grid_dp.basic.lc_2684;

import java.util.Arrays;

class Solution {
    public int maxMoves(int[][] grid) {
        // 移动规则，右上、右下、右
        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < m; i++) {
                if (j == 0) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = Integer.MIN_VALUE;
                }
            }
        }
        int ans = 0;

        for (int j = 1; j < n; j++) {
            for (int i = 0; i < m; i++) {
                if (grid[i][j] > grid[i][j - 1]) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][j - 1] + 1);
                }
                if (i - 1 >= 0 && grid[i][j] > grid[i - 1][j - 1]) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + 1);
                }
                if (i + 1 < m && grid[i][j] > grid[i + 1][j - 1]) {
                    dp[i][j] = Math.max(dp[i][j], dp[i + 1][j - 1] + 1);
                }
                ans = Math.max(ans, dp[i][j]);
            }
        }
        return ans;
    }
}