package com.guof.linear_dp.single_string_problem_ik.arrange_a_mailbox;

import java.util.Arrays;

class Solution {
    public int minDistance(int[] houses, int k) {
        Arrays.sort(houses);

        int[][] dp = new int[houses.length][k];
        for (int i = 0; i < dp.length; i++) {
            if (i != 0) {
                Arrays.fill(dp[i], Integer.MAX_VALUE);
            }
        }


        // 初始化只有一个油桶的最短距离
        for (int i = 0; i < houses.length; i++) {
            int dist = 0;
            int position = houses[i / 2];
            for (int j = 0; j <= i; j++) {
                dist += Math.abs(houses[j] - position);
            }
            dp[i][0] = dist;
        }

        for (int i = 1; i < houses.length; i++) {
            for (int j = 1; j < k; j++) {
                for (int i0 = 0; i0 < i; i0++) {
                    int dist = 0;
                    int position = houses[(i0 + 1 + i) / 2];
                    for (int l = i0 + 1; l <= i; l++) {
                        dist += Math.abs(houses[l] - position);
                    }
                    dp[i][j] = Math.min(dp[i][j], dp[i0][j - 1] + dist);
                }
            }
        }
        return dp[houses.length - 1][k - 1];
    }
}