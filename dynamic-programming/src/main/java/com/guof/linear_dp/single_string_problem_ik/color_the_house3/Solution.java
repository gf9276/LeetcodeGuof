package com.guof.linear_dp.single_string_problem_ik.color_the_house3;

import java.util.Arrays;

class Solution {
    public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
        for (int i = 0; i < m; ++i) {
            --houses[i];
        }
        // dp 所有元素初始化为极大值
        int[][][] dp = new int[m][n][target];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                Arrays.fill(dp[i][j], Integer.MAX_VALUE);
            }
        }
        // i 是 前i+1个房子
        // j 是 第j+1种颜色
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; ++j) {
                if (houses[i] != -1 && houses[i] != j) {
                    // 已经有颜色了，并且这个颜色还不是当前轮到的颜色
                    // 显然不满足dp要求
                    continue;
                }
                for (int k = 0; k < target; k++) {
                    if (i == 0) {
                        // 如果i==0的话，需要特殊处理一下
                        if (k == 0) {
                            if (houses[i] == j) {
                                dp[i][j][k] = 0;
                            } else {
                                dp[i][j][k] = cost[i][j];
                            }
                        }
                    } else {
                        // 如果i不是0，可以往下走了
                        // 若街区数量不变的话
                        if (dp[i - 1][j][k] != Integer.MAX_VALUE) {
                            if (houses[i] == j) {
                                dp[i][j][k] = Math.min(dp[i][j][k], dp[i - 1][j][k]);
                            } else {
                                dp[i][j][k] = Math.min(dp[i][j][k], dp[i - 1][j][k] + cost[i][j]);
                            }
                        }
                        // 若街区数量会发生变化的话，当然是之前的加上现在的花费的最小值了，街区发生变化，至少也是2个街区吧
                        if (k > 0) {
                            for (int l = 0; l < n; l++) {
                                if (l != j) {
                                    if (dp[i - 1][l][k - 1] != Integer.MAX_VALUE) {
                                        if (houses[i] == j) {
                                            dp[i][j][k] = Math.min(dp[i][j][k], dp[i - 1][l][k - 1]);
                                        } else {
                                            dp[i][j][k] = Math.min(dp[i][j][k], dp[i - 1][l][k - 1] + cost[i][j]);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        int output = Integer.MAX_VALUE;
        for (int i = 0; i < dp[0].length; i++) {
            output = Math.min(dp[m - 1][i][target - 1], output);
        }
        return output == Integer.MAX_VALUE ? -1 : output;
    }
}