package com.guof.start_dp.climb_stairs.lc_70;


// leetcode 70题
// 爬楼梯
// 每次爬1到2格
// 几种方法

class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
