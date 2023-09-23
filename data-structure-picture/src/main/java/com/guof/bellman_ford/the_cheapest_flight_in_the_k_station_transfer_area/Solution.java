package com.guof.bellman_ford.the_cheapest_flight_in_the_k_station_transfer_area;

import java.util.Arrays;

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // 从 src 到 所有里 过 k 点的最小价格
        int[][] dp = new int[k + 1][n];

        // 初始值都为无穷
        for (int[] ints : dp) {
            Arrays.fill(ints, Integer.MAX_VALUE);
        }
        for (int[] flight : flights) {
            if (flight[0] == src) {
                // 这些是可以直达的
                dp[0][flight[1]] = flight[2];
            }
        }
        dp[0][src] = 0;

        for (int i = 1; i < k + 1; i++) {
            for (int[] flight : flights) {
                // 直接所有的都遍历一遍
                int curSrc = flight[0];
                int curDst = flight[1];
                int curCost = flight[2];
                dp[i][curDst] = Math.min(dp[i][curDst], dp[i - 1][curDst]); // 至少也是这个数字
                // 如果能抵达上一个点，更新现阶段的最小值
                if (dp[i - 1][curSrc] != Integer.MAX_VALUE && dp[i - 1][curSrc] + curCost < dp[i][curDst]) {
                    dp[i][curDst] = dp[i - 1][curSrc] + curCost;
                }
            }
        }
        return dp[k][dst] == Integer.MAX_VALUE ? -1 : dp[k][dst];
    }
}