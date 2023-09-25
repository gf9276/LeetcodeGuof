package com.guof.linear_dp.matrix_problem_matrix_dp_ijk.maximum_rectangle;

import java.util.Arrays;

class Solution {
    public int maximalRectangle(char[][] matrix) {
        // 能把三维压缩成二维，解题是相当方便的
        int m = matrix.length;
        int n = matrix[0].length;
        int output = 0;
        char[] curInput = new char[n];

        for (int i = 0; i < m; i++) {
            Arrays.fill(curInput, '1');
            for (int j = i; j < m; j++) {
                for (int l = 0; l < n; l++) {
                    if (matrix[j][l] == '0') {
                        curInput[l] = '0';
                    }
                }
                if ((j - i + 1) * n < output) {
                    continue;
                }
                output = Math.max(output, getMaxLen(curInput) * (j - i + 1));
            }
        }
        return output;
    }


    public int getMaxLen(char[] input) {
        // 获取向量里最大连续1的个数
        int[] dp = new int[input.length]; // dp[i] 表示连续1的长度
        int output = 0;

        for (int i = 0; i < input.length; i++) {
            if (input[i] == '1') {
                dp[i] = i - 1 >= 0 ? dp[i - 1] + 1 : 1;
            }
            output = Math.max(output, dp[i]);
        }

        return output;
    }
}