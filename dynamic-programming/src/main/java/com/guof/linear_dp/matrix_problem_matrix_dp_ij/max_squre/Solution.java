package com.guof.linear_dp.matrix_problem_matrix_dp_ij.max_squre;

class Solution {
    public int maximalSquare(char[][] matrix) {
        // 这里有个重点，转移方程为什么可以左边三个取最小值呢？
        int m = matrix.length;
        int n = matrix[0].length;
        // 起点横坐标，起点纵坐标，尺寸(k+1)
        int[][] dp = new int[m][n];
        int output = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '0') {
                    continue;
                }
                int baseSize = 0;
                if (i > 0 && j > 0) {
                    baseSize = dp[i - 1][j - 1];
                    baseSize = Math.min(baseSize, dp[i][j - 1]);
                    baseSize = Math.min(baseSize, dp[i - 1][j]);
                }
                dp[i][j] = baseSize + 1;
                output = Math.max(dp[i][j], output);
            }
        }
        return output * output;
    }
}