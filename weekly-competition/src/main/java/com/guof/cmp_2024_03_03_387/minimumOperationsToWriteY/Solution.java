package com.guof.cmp_2024_03_03_387.minimumOperationsToWriteY;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

class Solution {
    public int minimumOperationsToWriteY(int[][] grid) {
        // 统计出现次数
        int[] notYCnt = new int[3];
        int[] YCnt = new int[3];

        int n = grid.length;

        for (int i = 0; i <= n / 2; i++) {
            YCnt[grid[i][i]]++;
            YCnt[grid[i][n - i - 1]]++;
        }
        for (int i = n / 2; i < n; i++) {
            YCnt[grid[i][n / 2]]++;
        }

        YCnt[grid[n / 2][n / 2]]--;
        YCnt[grid[n / 2][n / 2]]--;
//        YCnt[grid[n / 2][n / 2]]--;

        for (int[] ints : grid) {
            for (int j = 0; j < n; j++) {
                notYCnt[ints[j]]++;
            }
        }

        for (int i = 0; i < 3; i++) {
            notYCnt[i] -= YCnt[i];
        }

        int output = Integer.MAX_VALUE;
        int YNbr = 0;
        int notYNbr = 0;
        for (int i = 0; i < 3; i++) {
            YNbr += YCnt[i];
            notYNbr += notYCnt[i];
        }

        // Y变i，notY变j
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == j) {
                    continue;
                }
                output = Math.min(output, YNbr - YCnt[i] + notYNbr - notYCnt[j]);
            }
        }
        return output;
    }
}