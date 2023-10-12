package com.guof.linear_dp.backpack_dp.one_zero;

class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        // 拿？个，最大值为m 最大值为n 的子集
        // 前n个里，满足最大值为mn的最大长度
        int[][][] dp = new int[strs.length + 1][m + 1][n + 1];

        dp[0][0][0] = 0;
        int[] curNbr = getNbr(strs[0]);

        // 先拿一个看看数量
        for (int i = curNbr[0]; i < dp[1].length; i++) {
            for (int j = curNbr[1]; j < dp[1][i].length; j++) {
                dp[1][i][j] = 1;
            }
        }

        for (int i = 2; i < dp.length; i++) {
            curNbr = getNbr(strs[i - 1]);
            for (int j = 0; j < dp[i].length; j++) {
                for (int k = 0; k < dp[i][j].length; k++) {// 获取 当前 字符串 01的个数
                    dp[i][j][k] = dp[i - 1][j][k];
                    if (j - curNbr[0] >= 0 && k - curNbr[1] >= 0) {
                        dp[i][j][k] = Math.max(dp[i - 1][j][k], dp[i - 1][j - curNbr[0]][k - curNbr[1]] + 1);
                    }
                }
            }
        }
        return dp[strs.length][m][n];
    }

    public int[] getNbr(String s) {
        // 统计0和1的个数
        int[] output = new int[2];
        for (char c : s.toCharArray()) {
            output[c - '0']++;
        }
        return output;
    }
}