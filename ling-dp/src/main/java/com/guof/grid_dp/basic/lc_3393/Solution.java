package com.guof.grid_dp.basic.lc_3393;

import java.util.HashMap;
import java.util.Map;

class Solution {
    int[][] grid;
    int k;

    public int countPathsWithXorValue(int[][] grid, int k) {
        // 不同为1
        // 同为0
        // 最大的问题是，抑或为k
        this.grid = grid;
        this.k = k;
        Integer[][][] memo = new Integer[grid.length][grid[0].length][128];
        return dfs(grid.length - 1, grid[0].length - 1, k, memo);
    }


    public int dfs(int curX, int curY, int needK, Integer[][][] memo) {
        if (curX == 0 && curY == 0) {
            // 边界的话，看看值对的上不
            return this.grid[curX][curY] == needK ? 1 : 0;
        }
        if (curX < 0 || curY < 0) {
            // 没有可能了
            return 0;
        }
        if (memo[curX][curY][needK] != null) {
            return memo[curX][curY][needK];
        }
        int ans1 = dfs(curX - 1, curY, needK ^ grid[curX][curY], memo) % 1000000007;
        int ans2 = dfs(curX, curY - 1, needK ^ grid[curX][curY], memo) % 1000000007;
        int ans = (ans2 + ans1) % 1000000007;
        memo[curX][curY][needK] = ans;
        return ans;
    }
}