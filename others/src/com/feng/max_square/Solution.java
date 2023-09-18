package com.feng.max_square;


import java.util.Arrays;

class Solution {
    public int maximalSquare(char[][] matrix) {
        // 题目说 1 <= m, n <= 300
        int m = matrix.length;
        int n = matrix[0].length;
        int output = 0;

        for (int i = 0; i < m; i++) {
            char[] input = new char[n];
            Arrays.fill(input, '1');
            for (int j = i; j < m; j++) {
                for (int k = 0; k < n; k++) {
                    if (matrix[j][k] == '0') {
                        input[k] = '0';
                    }
                }
                if ((j - i + 1) * (j - i + 1) <= output) {
                    continue;
                }
                int maxLength = getMaxOne(input);
                maxLength = Math.min(maxLength, j - i + 1);
                output = Math.max(output, maxLength * maxLength);
            }
        }
        return output;
    }

    public int getMaxOne(char[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int output = 0;
        int newDp = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == '1') {
                newDp = i - 1 >= 0 ? newDp + 1 : 1;
                output = Math.max(newDp, output);
            } else {
                newDp = 0;
            }
        }
        return output;
    }
}