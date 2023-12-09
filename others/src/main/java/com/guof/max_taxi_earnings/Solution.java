package com.guof.max_taxi_earnings;


import java.util.ArrayList;
import java.util.List;

class Solution {
    public long maxTaxiEarnings(int n, int[][] rides) {
        // 问题转换一下，就是寻找最优路径，用dp
        List<int[]>[] lists = new ArrayList[n + 1]; // 以 n 为终点 的 起点 + 小费

        for (int i = 0; i < lists.length; i++) {
            lists[i] = new ArrayList<>();
        }
        for (int[] ride : rides) {
            lists[ride[1]].add(new int[]{ride[0], ride[2]});
        }

        long[] dp = new long[n + 1]; // 以 n 为终点，赚的最多的钱

        for (int i = 1; i < dp.length; i++) {
            dp[i] = dp[i - 1];
            for (int[] curPoint : lists[i]) {
                dp[i] = Math.max(dp[curPoint[0]] + curPoint[1] + i - curPoint[0], dp[i]);
            }
        }
        return dp[n];
    }
}