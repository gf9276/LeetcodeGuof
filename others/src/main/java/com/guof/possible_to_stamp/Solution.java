package com.guof.possible_to_stamp;


class Solution {
    public boolean possibleToStamp(int[][] grid, int stampHeight, int stampWidth) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] sum = new int[m][n];
        // 统计前缀和
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                sum[i][j] = grid[i][j];
                if (i > 0) {
                    sum[i][j] += sum[i - 1][j];
                }
                if (j > 0) {
                    sum[i][j] += sum[i][j - 1];
                }
                if (i > 0 && j > 0) {
                    sum[i][j] -= sum[i - 1][j - 1];
                }
            }
        }

        // 统计差分情况
        int[][] diff = new int[m][n]; // 差分
        for (int i = 0; i <= m - stampHeight; i++) {
            for (int j = 0; j <= n - stampWidth; j++) {
                int total = sum[i + stampHeight - 1][j + stampWidth - 1];
                if (i > 0) {
                    total -= sum[i - 1][j + stampWidth - 1];
                }
                if (j > 0) {
                    total -= sum[i + stampHeight - 1][j - 1];
                }
                if (i > 0 && j > 0) {
                    total += sum[i - 1][j - 1];
                }
                if (total == 0) {
                    diff[i][j]++;
                    if (i + stampHeight < m) {
                        diff[i + stampHeight][j]--;
                    }
                    if (j + stampWidth < n) {
                        diff[i][j + stampWidth]--;
                    }
                    if (i + stampHeight < m && j + stampWidth < n) {
                        diff[i + stampHeight][j + stampWidth]++;
                    }
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i > 0) {
                    diff[i][j] += diff[i - 1][j];
                }
                if (j > 0) {
                    diff[i][j] += diff[i][j - 1];
                }
                if (i > 0 && j > 0) {
                    diff[i][j] -= diff[i - 1][j - 1];
                }
                if (diff[i][j] == 0 && grid[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }
}