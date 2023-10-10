package com.guof.prefix_sum_and_monotonic_stack_monotonic_queue.maximum_rectangle;

import java.util.Arrays;

class Solution {
    public int maximalRectangle(char[][] matrix) {
        // 化作一维
        // 将m*n的矩阵压缩为1*n的向量
        // 若该向量中最大1的长度为length，那么全为1的矩阵面积最大值为 length * m
        int output = 0;

        for (int i = 0; i < matrix.length; i++) {
            char[] input = new char[matrix[i].length];
            Arrays.fill(input, '1'); // 这里可以看作与运算
            for (int j = i; j < matrix.length; j++) {
                int curWidth = j - i + 1; // 矩阵的宽度
                for (int k = 0; k < matrix[j].length; k++) {
                    if (matrix[j][k] == '0') {
                        // 如果矩阵的某一行存在0，那压缩后的向量该值也为0
                        input[k] = '0';
                    }
                }
                int curLength = getMaxLen(input); // 矩阵的长度
                if (curLength * (matrix.length - i) <= output) {
                    // 1的长度只会越来越小，即长度只会越来越小
                    // 如果长*最大的宽，即 curLength * (matrix.length - i) 仍然比output小
                    // 那这里就没有继续下去的意义了
                    break;
                }
                output = Math.max(curLength * curWidth, output); // 更新最大值
            }
        }
        return output;
    }

    public int getMaxLen(char[] input) {
        // 获取一个向量中，连续1的最大长度
        int[] dp = new int[input.length];
        int output = 0;
        for (int i = 0; i < dp.length; i++) {
            dp[i] = i - 1 >= 0 ? dp[i - 1] : 0;
            dp[i] = (input[i] == '1') ? dp[i] + 1 : 0;
            output = Math.max(output, dp[i]);
        }
        return output;
    }
}