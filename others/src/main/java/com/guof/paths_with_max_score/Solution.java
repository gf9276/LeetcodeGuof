package com.guof.paths_with_max_score;


import java.util.List;

class Solution {
    public int[] pathsWithMaxScore(List<String> board) {
        int mod = 1000000007;
        int m = board.size();
        int n = board.get(0).length();
        // 撑死也就900分，咋滴，900能上天啊
        int maxScore = 0;
        for (String s : board) {
            for (char c : s.toCharArray()) {
                if (c >= '0' && c <= '9') {
                    maxScore += c - '0';
                }
            }
        }

        // maxScore就是最大分数
        int[][][] dp = new int[2][m][n]; // 0表示获得的最大分数，1表示可能性
        // dp[i][j][k]，表示抵达坐标j,k并拿到i分的可能数

        dp[0][m - 1][n - 1] = 0;
        dp[1][m - 1][n - 1] = 1;

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (board.get(i).charAt(j) == 'X') {
                    // 是障碍
                    continue;
                }
                if (i == m - 1 && j == n - 1) {
                    // 是起点
                    continue;
                }
                int curScore;
                if (i == 0 && j == 0) {
                    // 是终点
                    curScore = 0;
                } else {
                    curScore = board.get(i).charAt(j) - '0'; // 当前分数
                }
                // 看看右边
                if (j < n - 1 && dp[1][i][j + 1] != 0) {
                    if (dp[0][i][j] < dp[0][i][j + 1] + curScore) {
                        dp[0][i][j] = dp[0][i][j + 1] + curScore;
                        dp[1][i][j] = dp[1][i][j + 1];
                    } else if (dp[0][i][j] == dp[0][i][j + 1] + curScore) {
                        dp[1][i][j] = (dp[1][i][j] + dp[1][i][j + 1]) % mod;
                    }
                }
                // 看看下面
                if (i < m - 1 && dp[1][i + 1][j] != 0) {
                    if (dp[0][i][j] < dp[0][i + 1][j] + curScore) {
                        dp[0][i][j] = dp[0][i + 1][j] + curScore;
                        dp[1][i][j] = dp[1][i + 1][j];
                    } else if (dp[0][i][j] == dp[0][i + 1][j] + curScore) {
                        dp[1][i][j] = (dp[1][i][j] + dp[1][i + 1][j]) % mod;
                    }
                }
                // 看看右下角
                if (j < n - 1 && i < m - 1 && dp[1][i + 1][j + 1] != 0) {
                    if (dp[0][i][j] < dp[0][i + 1][j + 1] + curScore) {
                        dp[0][i][j] = dp[0][i + 1][j + 1] + curScore;
                        dp[1][i][j] = dp[1][i + 1][j + 1];
                    } else if (dp[0][i][j] == dp[0][i + 1][j + 1] + curScore) {
                        dp[1][i][j] = (dp[1][i][j] + dp[1][i + 1][j + 1]) % mod;
                    }
                }
            }
        }

        int[] output = new int[]{0, 0};
        output[0] = dp[0][0][0];
        output[1] = dp[1][0][0];
        return output;
    }
}