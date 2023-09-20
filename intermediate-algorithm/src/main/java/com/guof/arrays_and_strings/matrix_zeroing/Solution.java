package com.guof.arrays_and_strings.matrix_zeroing;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

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
        Set<Integer> rows = new HashSet<>();
        Set<Integer> cols = new HashSet<>();


        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    rows.add(i);
                    cols.add(j);
                }
            }
        }

        for (int row : rows) {
            Arrays.fill(matrix[row], 0);
        }
        for (int col : cols) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][col] = 0;
            }
        }

    }
}