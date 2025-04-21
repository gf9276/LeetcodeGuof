package com.guof.start_dp.robbery.lc_2320;


// leetcode 2320
// 打家劫舍

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int countHousePlacements(int n) {
        // 计算一般成起来被
        long[][] dp = new long[n + 1][2];
        dp[1][0] = 1;
        dp[1][1] = 1;
        for (int i = 2; i < dp.length; i++) {
            dp[i][0] = (dp[i - 1][0] + dp[i - 1][1]) % 1000000007;
            dp[i][1] = (dp[i - 1][0]) % 1000000007;
        }
        long ans1 = (dp[dp.length - 1][0] + dp[dp.length - 1][1]) % 1000000007;

        return (int) ((ans1 * ans1) % 1000000007);
    }
}