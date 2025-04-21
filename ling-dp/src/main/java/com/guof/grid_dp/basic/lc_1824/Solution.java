package com.guof.grid_dp.basic.lc_1824;

class Solution {
    int[] obstacles;

    public int minSideJumps(int[] obstacles) {
        this.obstacles = obstacles;
        return dfs(0, 2, obstacles.length - 1, new Integer[obstacles.length][4]);
    }

    public int dfs(int curX, int curY, int maxN, Integer[][] memo) {
        if (curX == maxN) {
            // 抵达终点了
            return this.obstacles[curX] == curY ? 0x3f3f3f3f : 0;
        }
        if (memo[curX][curY] != null) {
            return memo[curX][curY];
        }
        int ans = 0x3f3f3f3f;

        if (obstacles[curX + 1] != 1 && obstacles[curX] != 1) {
            // 去1号跑道
            ans = Math.min(ans, dfs(curX + 1, 1, maxN, memo) + (curY == 1 ? 0 : 1));
        }

        if (obstacles[curX + 1] != 2 && obstacles[curX] != 2) {
            // 去2号跑道
            ans = Math.min(ans, dfs(curX + 1, 2, maxN, memo) + (curY == 2 ? 0 : 1));
        }
        if (obstacles[curX + 1] != 3 && obstacles[curX] != 3) {
            // 去2号跑道
            ans = Math.min(ans, dfs(curX + 1, 3, maxN, memo) + (curY == 3 ? 0 : 1));
        }
        memo[curX][curY] = ans;
        return ans;
    }
}