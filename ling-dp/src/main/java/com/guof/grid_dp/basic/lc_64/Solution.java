package com.guof.grid_dp.basic.lc_64;

class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                dp[i][j] = Math.min(i - 1 >= 0 ? dp[i - 1][j] : Integer.MAX_VALUE, j - 1 >= 0 ? dp[i][j - 1] : Integer.MAX_VALUE);
                if (dp[i][j] == Integer.MAX_VALUE)
                    dp[i][j] = 0;
                dp[i][j] += grid[i][j];
            }
        }
        return dp[m - 1][n - 1];
    }
}