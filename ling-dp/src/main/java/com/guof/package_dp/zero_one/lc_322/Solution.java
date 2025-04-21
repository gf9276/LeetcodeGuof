package com.guof.package_dp.zero_one.lc_322;

import java.util.Arrays;

class Solution {
    public int coinChange(int[] coins, int amount) {
        int ans = 0;
        int[] dp = new int[amount + 1]; // 拿到对应钱的最小次数
        Arrays.fill(dp, 0x3f3f3f3f);
        dp[0] = 0;
        for (int coin : coins) {
            for (int i = 0; i < dp.length; i++) {
                if (i - coin >= 0) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] == 0x3f3f3f3f ? -1 : dp[amount];
    }
}