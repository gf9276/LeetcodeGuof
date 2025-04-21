package com.guof.grid_dp.basic.lc_3418;

import java.util.HashMap;

class Solution {
    int[][] coins;

    public int maximumAmount(int[][] coins) {
        this.coins = coins;
        int m = coins.length;
        int n = coins[0].length;
        return dfs(2, m - 1, n - 1, new Integer[3][m][n]);
    }

    public int dfs(int choose, int curX, int curY, Integer[][][] memo) {
        if (curX < 0 || curY < 0) {
            return -0x3f3f3f3f;
        }
        if (curX == 0 && curY == 0) {
            if (choose > 0 && this.coins[0][0] < 0) {
                return 0;
            }
            return this.coins[0][0];
        }
        if (memo[choose][curX][curY] != null) {
            return memo[choose][curX][curY];
        }
        int ans = this.coins[curX][curY] + Math.max(dfs(choose, curX - 1, curY, memo), dfs(choose, curX, curY - 1, memo));
        if (this.coins[curX][curY] < 0 && choose > 0) {
            // 要被抢走了，试一下不被抢走
            int ans1 = Math.max(dfs(choose - 1, curX - 1, curY, memo), dfs(choose - 1, curX, curY - 1, memo));
            ans = Math.max(ans1, ans);
        }
        memo[choose][curX][curY] = ans;
        return ans;
    }
}