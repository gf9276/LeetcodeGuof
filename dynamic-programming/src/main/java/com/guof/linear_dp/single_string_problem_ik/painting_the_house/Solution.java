package com.guof.linear_dp.single_string_problem_ik.painting_the_house;

import java.util.Arrays;
import java.util.OptionalInt;

class Solution {
    public int minCost(int[][] costs) {
        int[][] dp = new int[costs.length + 1][costs[0].length];

        for (int i = 1; i <= costs.length; i++) {
            for (int j = 0; j < costs[0].length; j++) {
                for (int l = 0; l < costs[0].length; l++) {
                    if (l == j) {
                        continue;
                    }
                    if (dp[i][j] == 0) {
                        dp[i][j] = dp[i - 1][l] + costs[i - 1][j];
                    } else {
                        dp[i][j] = Math.min(dp[i - 1][l] + costs[i - 1][j], dp[i][j]);
                    }
                }
            }
        }
        return  Arrays.stream(dp[costs.length]).min().getAsInt();
    }
}