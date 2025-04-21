package com.guof.grid_dp.basic.lc_2304;

import java.util.Arrays;

class Solution {
    public int minPathCost(int[][] grid, int[][] moveCost) {
        // moveCost 值 为i移动到第j列的消耗
        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0) {
                    dp[i][j] = grid[i][j];
                } else {
                    dp[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 当前点的花费情况
                // 遍历上一行，找花费最低的
                for (int k = 0; k < n; k++) {
                    // k是上一行的
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][k] + moveCost[grid[i - 1][k]][j] + grid[i][j]);
                }
            }
        }
        return Arrays.stream(dp[m - 1]).min().getAsInt();
    }
}