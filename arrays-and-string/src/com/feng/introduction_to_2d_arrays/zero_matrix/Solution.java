package com.feng.introduction_to_2d_arrays.zero_matrix;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * ClassName: Solution
 * Package: com.feng.applying_basic_algorithmic_ideas.merge
 * Description:
 *
 * @Author guof
 * @Create 2023/5/15 21:32
 * @Version 1.0
 */

class Solution {
    public void setZeroes(int[][] matrix) {
        // 我的想法是，保留所有0的坐标
        Set<Integer> row = new HashSet<>();
        Set<Integer> column = new HashSet<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    row.add(i);
                    column.add(j);
                }
            }
        }
        for (int i : row) {
            Arrays.fill(matrix[i], 0);
        }
        for (int j : column) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][j] = 0;
            }
        }

    }
}