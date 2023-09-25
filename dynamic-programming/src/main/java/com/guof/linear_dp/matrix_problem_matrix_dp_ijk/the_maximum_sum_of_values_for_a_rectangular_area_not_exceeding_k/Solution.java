package com.guof.linear_dp.matrix_problem_matrix_dp_ijk.the_maximum_sum_of_values_for_a_rectangular_area_not_exceeding_k;

import java.util.Arrays;

class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;
        int output = Integer.MIN_VALUE;
        int[] curInput = new int[n];

        for (int i = 0; i < m; i++) {
            Arrays.fill(curInput, 0);
            for (int j = i; j < m; j++) {
                for (int l = 0; l < n; l++) {
                    curInput[l] += matrix[j][l];
                }
                int maxSum = getMaxSum(curInput, k);
                if (maxSum == k) {
                    return k;
                } else {
                    output = Math.max(output, maxSum);
                }
            }
        }
        return output;
    }

    public int getMaxSum(int[] input, int k) {
        // 从 i 到 j 的和
        int[][] dp = new int[input.length][input.length];
        int output = Integer.MIN_VALUE;

        for (int i = 0; i < input.length; i++) {
            for (int j = i; j < input.length; j++) {
                dp[i][j] = j > i ? dp[i][j - 1] + input[j] : input[j];
                if (dp[i][j] < k) {
                    output = Math.max(output, dp[i][j]);
                } else if (dp[i][j] == k) {
                    return k;
                }
            }
        }

        return output;
    }
}