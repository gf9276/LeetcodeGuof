package com.guof.two_dimensional_prefix_and.region_and_retrieval_matrix_invariant;


class NumMatrix {

    int[][] dp;

    public NumMatrix(int[][] matrix) {
        dp = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                dp[i][j] = matrix[i][j];
                if (j - 1 >= 0) {
                    dp[i][j] += dp[i][j - 1];
                }
                if (i - 1 >= 0) {
                    dp[i][j] += dp[i - 1][j];
                }
                if (i - 1 >= 0 && j - 1 >= 0) {
                    dp[i][j] -= dp[i - 1][j - 1];
                }
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int output = dp[row2][col2];

        if (row1 - 1 >= 0) {
            output -= dp[row1 - 1][col2];
        }
        if (col1 - 1 >= 0) {
            output -= dp[row2][col1 - 1];
        }
        if (row1 - 1 >= 0 && col1 - 1 >= 0) {
            output += dp[row1 - 1][col1 - 1];
        }
        return output;
    }
}