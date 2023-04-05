package com.feng.arrays_and_strings.matrix_zeroing;

import java.util.Arrays;

/**
 * ClassName: Solution
 * Package: com.feng.arrays_and_strings.matrix_zeroing
 * Description:
 *
 * @Author guof
 * @Create 2023/4/4 18:11
 * @Version 1.0
 */
class Solution {
    public void setZeroes(int[][] matrix) {
        boolean row_flag = false;
        boolean line_flag = false;

        // 行原始标志位3
        for (int[] ints : matrix) {
            if (ints[0] == 0) {
                row_flag = true;
                break;
            }
        }
        // 列原始标志位
        for (int j = 0; j < matrix[0].length; j++) {
            if (matrix[0][j] == 0) {
                line_flag = true;
                break;
            }
        }

        // 其他的映射过来
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }

        for (int i = 1; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                Arrays.fill(matrix[i], 0);
            }
        }
        for (int j = 1; j < matrix[0].length; j++) {
            if (matrix[0][j] == 0) {
                for (int i = 0; i < matrix.length; i++) {
                    matrix[i][j] = 0;
                }
            }
        }

        if (row_flag) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }
        if (line_flag) {
            Arrays.fill(matrix[0], 0);
        }

    }
}