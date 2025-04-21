package com.guof.grid_dp.basic.lc_1289;

import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    public int minFallingPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        PriorityQueue<Integer[]> queue = new PriorityQueue<>((a, b) -> (b[1] - a[1])); // 最大堆
        int[][] dp = new int[m][n];
        for (int i = 0; i < n; i++) {
            dp[0][i] = grid[0][i];
            if (queue.size() < 2) {
                queue.add(new Integer[]{i, dp[0][i]});
            } else {
                if (dp[0][i] < queue.peek()[1]) {
                    queue.poll();
                    queue.add(new Integer[]{i, dp[0][i]});
                }
            }
        }

        for (int i = 1; i < m; i++) {
            Integer[] big = queue.poll();
            Integer[] small = queue.poll();
            for (int j = 0; j < n; j++) {
                if (small[0] == j) dp[i][j] = big[1] + grid[i][j];
                else dp[i][j] = small[1] + grid[i][j];
                if (queue.size() < 2) {
                    queue.add(new Integer[]{j, dp[i][j]});
                } else {
                    if (dp[i][j] < queue.peek()[1]) {
                        queue.poll();
                        queue.add(new Integer[]{j, dp[i][j]});
                    }
                }
            }
        }
        if (queue.size() > 1) queue.poll();
        return queue.peek()[1];
    }
}