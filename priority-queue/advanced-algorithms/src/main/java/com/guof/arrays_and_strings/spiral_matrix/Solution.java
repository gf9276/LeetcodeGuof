package com.guof.arrays_and_strings.spiral_matrix;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: Solution
 * Package: com.feng.dynamic_programming.climb_stairs
 * Description:
 *
 * @Author guof
 * @Create 2023/3/27 22:23
 * @Version 1.0
 */
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> output = new ArrayList<>();

        // 给定四大边界
        int up = 0;
        int down = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;

        int curRow = 0;
        int curCol = 0;
        while (left <= right && up <= down) {
            for (curCol = left; curCol <= right; curCol++) {
                output.add(matrix[curRow][curCol]);
            }
            curCol--;

            curRow = up + 1;
            if (curRow > down) {
                break;
            }
            for (curRow = up + 1; curRow <= down; curRow++) {
                output.add(matrix[curRow][curCol]);
            }
            curRow--;

            curCol = right - 1;
            if (curCol < left) {
                break;
            }
            for (curCol = right - 1; curCol >= left; curCol--) {
                output.add(matrix[curRow][curCol]);
            }
            curCol++;

            curRow = down - 1;
            if (curRow < up + 1) {
                break;
            }
            for (curRow = down - 1; curRow >= up + 1; curRow--) {
                output.add(matrix[curRow][curCol]);
            }
            curRow++;

            left++;
            right--;
            up++;
            down--;
        }
        return output;
    }
}