package com.feng.dynamic_programming.change_exchange;

import java.util.Arrays;

/**
 * ClassName: Solution
 * Package: com.feng.dynamic_programming.change_exchange
 * Description:
 *
 * @Author guof
 * @Create 2023/4/23 17:23
 * @Version 1.0
 */
class Solution {
    public int coinChange(int[] coins, int amount) {
        // 搞得不像是动态规划。。。

        if (amount == 0) {
            return 0;
        }

        int[] dp = new int[amount + 1]; // 凑出几块钱的最小数量，零块钱就是0
        Arrays.fill(dp, 99999); // 初始化为很大很大
        dp[0] = 0; // 第0个始终是0
        Arrays.sort(coins); // 先排序再说
        for (int coin : coins) {
            for (int j = 1; j * coin < dp.length; j++) {
                dp[j * coin] = j;
            }
        }

        for (int i = 1; i < dp.length; i++) {
            if (dp[i] > 2) {
                for (int coin : coins) {
                    if (i - coin >= 0) {
                        dp[i] = Math.min(dp[i - coin] + 1, dp[i]);
                    }
                }
            }
        }

        if (dp[dp.length - 1] >= 99999) {
            return -1;
        } else {
            return dp[dp.length - 1];
        }
    }
}