package com.guof.find_paths;


class Solution {
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        if (maxMove == 0) {
            return 0;
        }
        int mod = 1000000007;
        // 用dp，恰好移动 n 步，并且初始坐标为 ？？ 出界的机会
        int[][][] dp = new int[maxMove][m][n]; // 我觉得这个主意不好，三重循环，不太好，先写了吧

        // 周围一圈，一步出去
        for (int i = 0; i < m; i++) {
            dp[0][i][0] += 1;
            dp[0][i][n - 1] += 1;
        }
        for (int i = 0; i < n; i++) {
            dp[0][0][i] += 1;
            dp[0][m - 1][i] += 1;
        }


        for (int i = 1; i < maxMove; i++) {
            // 开始统计步数
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < n; k++) {
                    if (j > 0) {
                        dp[i][j][k] = (dp[i][j][k] + dp[i - 1][j - 1][k]) % mod;
                    }
                    if (j < m - 1) {
                        dp[i][j][k] = (dp[i][j][k] + dp[i - 1][j + 1][k]) % mod;
                    }
                    if (k > 0) {
                        dp[i][j][k] = (dp[i][j][k] + dp[i - 1][j][k - 1]) % mod;
                    }
                    if (k < n - 1) {
                        dp[i][j][k] = (dp[i][j][k] + dp[i - 1][j][k + 1]) % mod;
                    }
                }
            }
        }
        int output = 0;
        for (int i = 0; i < maxMove; i++) {
            output = (output + dp[i][startRow][startColumn]) % mod;
        }
        return output;
    }
}