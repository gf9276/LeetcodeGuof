package com.guof.start_dp.climb_stairs.lc_746;


// leetcode 746 题
// 最小花费爬楼梯
// 可以选择从0或者1开始爬

class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length; // 这是楼梯的层数
        int[] dp = new int[n + 1];
        dp[0] = 0; // 没有花费哈
        dp[1] = 0; // 也没有花费哈

        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.min(cost[i - 2] + dp[i - 2], cost[i - 1] + dp[i - 1]);
        }
        return dp[n];
    }
}