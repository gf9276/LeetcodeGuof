package com.guof.linear_dp.matrix_problem_matrix_dp_ijk.maximum_submatrix;

import java.util.Arrays;

class Solution {
    public int[] getMaxMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int output = Integer.MIN_VALUE;
        int[] outputCoord = new int[4];
        int[] curInput = new int[n];

        for (int i = 0; i < m; i++) {
            Arrays.fill(curInput, 0);
            for (int j = i; j < m; j++) {
                for (int l = 0; l < n; l++) {
                    curInput[l] += matrix[j][l];
                }
                int[] curOutput = getMaxSum(curInput);
                if (curOutput[0] > output) {
                    outputCoord[0] = i;
                    outputCoord[1] = curOutput[1];
                    outputCoord[2] = j;
                    outputCoord[3] = curOutput[2];
                    output = curOutput[0];
                }

            }
        }
        return outputCoord;
    }


    public int[] getMaxSum(int[] input) {
        // 前 i 个最大和
        // 这个明显比之前那个高级，唉，单维就可以用了
        int[] dp = new int[input.length];
        int[][] coord = new int[input.length][2];
        dp[0] = input[0];
        int output = input[0];
        int[] outputCoord = new int[3];
        for (int i = 1; i < input.length; i++) {
            if (dp[i - 1] + input[i] > input[i]) {
                coord[i][0] = coord[i - 1][0];
                coord[i][1] = coord[i - 1][1] + 1;
                dp[i] = dp[i - 1] + input[i];
            } else {
                coord[i][0] = i;
                coord[i][1] = i;
                dp[i] = input[i];
            }
            if (dp[i] > output) {
                output = dp[i];
                outputCoord[1] = coord[i][0];
                outputCoord[2] = coord[i][1];
                outputCoord[0] = output;
            }
        }
        return outputCoord;
    }
}