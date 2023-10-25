package com.guof.num_roll_to_target;


class Solution {
    public int numRollsToTarget(int n, int k, int target) {
        int mod = 1000000007;
        int[][] dp = new int[n + 1][target + 1]; // 投掷n次，成为target的机会.数量级30000

        dp[0][0] = 1; // 目标为零，不投也是一种可能，不是吗。当然，投了就没有可能了
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                for (int l = j - k; l <= j - 1; l++) {
                    if (l < 0) {
                        // 小于0屁事干不了
                        continue;
                    }
                    dp[i][j] += dp[i - 1][l]; // 是一种可能
                    dp[i][j] %= mod; // 是一种可能
                }
            }
        }

        return dp[n][target];
    }
}