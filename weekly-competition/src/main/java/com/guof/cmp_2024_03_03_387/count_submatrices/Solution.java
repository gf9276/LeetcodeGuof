package com.guof.cmp_2024_03_03_387.count_submatrices;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int countSubmatrices(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] prefix = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                prefix[i][j] = grid[i][j];
                if (i - 1 >= 0) {
                    prefix[i][j] += prefix[i - 1][j];
                }
                if (j - 1 >= 0) {
                    prefix[i][j] += prefix[i][j - 1];
                }
                if (i - 1 >= 0 && j - 1 >= 0) {
                    prefix[i][j] -= prefix[i - 1][j - 1];
                }
            }
        }

        int output = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (prefix[i][j] <= k) {
                    output++;
                } else {
                    break;
                }
            }
        }
        return output;
    }
}