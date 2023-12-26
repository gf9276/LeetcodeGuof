package com.guof.max_students;


import java.util.Arrays;

class Solution {
    public int maxStudents(char[][] seats) {
        int output = 0;
        // 1表示有人，0表示没人
        int m = seats.length;
        int n = seats[0].length;
        int ns = (1 << n);
        int[][] dp = new int[m][ns]; // 遍历，当前不坐的最大值，等于

        // 先都坐满，不管犯规与否
        int[] canSeat = new int[m];
        for (int i = 0; i < seats.length; i++) {
            for (int j = 0; j < seats[i].length; j++) {
                if (seats[i][j] == '.') {
                    canSeat[i] |= (1 << j);
                }
            }
        }

        // 第i行状态为 j 时，前n行+当前状态能有的最大学生数量

        for (int i = 0; i < m; i++) {
            // 当前行的子集
            for (int j = canSeat[i]; j >= 0; j = (j - 1) & canSeat[i]) {
                if ((j & (j >> 1)) != 0 || ((j & (j << 1)) != 0)) {
                    // 这个子集不行
                    continue;
                }
                int curJNbr = getNbr(j); // 当前行学生数量
                if (i == 0) {
                    dp[0][j] = curJNbr;
                } else {
                    // 上一行的子集
                    for (int k = canSeat[i - 1]; k >= 0; k = (k - 1) & canSeat[i - 1]) {
                        if (((k & (k >> 1)) != 0) || ((k & (k << 1)) != 0)) {
                            // 这个子集不行
                            continue;
                        }
                        if ((k & (j >> 1)) != 0 || ((k & (j << 1)) != 0)) {
                            // 这个子集不行
                            continue;
                        }
                        dp[i][j] = Math.max(dp[i][j], dp[i - 1][k] + curJNbr);
                        if (k == 0) {
                            break;
                        }
                    }
                }
                if (i == m - 1) {
                    // 最后一行了
                    output = Math.max(output, dp[i][j]);
                }
                if (j == 0) {
                    break;
                }
            }
        }
        return output;
    }

    public int getNbr(int x) {
        int output = 0;
        for (int i = x; i > 0; i -= lowbit(i)) {
            output++;
        }
        return output;
    }

    int lowbit(int x) {
        return x & -x;
    }
}