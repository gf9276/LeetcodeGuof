package com.guof.linear_dp.matrix_problem_matrix_dp_ijk.number_of_pizza_cutting_schemes;

class Solution {
    public int ways(String[] pizza, int k) {
        int m = pizza.length;
        int n = pizza[0].length();
        int mod = 1_000_000_007;
        int[][] apples = new int[m + 1][n + 1];
        int[][][] dp = new int[k + 1][m + 1][n + 1];

        // 获取苹果数量和初始化dp
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                apples[i][j] = pizza[i].charAt(j) == 'A' ? 1 : 0;
                apples[i][j] += apples[i][j + 1] + apples[i + 1][j] - apples[i + 1][j + 1];
                dp[1][i][j] = apples[i][j] > 0 ? 1 : 0;
            }
        }

        // 状态转移方程，前面已经初始完切一次的了，所以这里是2
        for (int curK = 2; curK <= k; curK++) {
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    for (int i2 = m - 1; i2 >= i + 1; i2--) {
                        if (apples[i][j] > apples[i2][j]) {
                            dp[curK][i][j] = (dp[curK][i][j] + dp[curK - 1][i2][j]) % mod;
                        } else {
                            break;
                        }
                    }
                    for (int j2 = n - 1; j2 >= j + 1; j2--) {
                        if (apples[i][j] > apples[i][j2]) {
                            dp[curK][i][j] = (dp[curK][i][j] + dp[curK - 1][i][j2]) % mod;
                        } else {
                            break;
                        }
                    }
                }
            }
        }
        return dp[k][0][0];
    }
}