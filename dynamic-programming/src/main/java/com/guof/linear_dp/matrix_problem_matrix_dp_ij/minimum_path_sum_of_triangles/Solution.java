package com.guof.linear_dp.matrix_problem_matrix_dp_ij.minimum_path_sum_of_triangles;

import java.util.Arrays;
import java.util.List;

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();
        int n = triangle.get(m - 1).size();
        int[][] dp = new int[m][n];

        // 初始化所有距离
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        dp[0][0] = triangle.get(0).get(0);

        for (int i = 1; i < m; i++) {
            for (int j = 0; j <= i; j++) {
                // 三角形，所以要小于等于i
                if (j != i) {
                    if (dp[i - 1][j] != Integer.MAX_VALUE && dp[i - 1][j] + triangle.get(i).get(j) < dp[i][j]) {
                        dp[i][j] = dp[i - 1][j] + triangle.get(i).get(j);
                    }
                }
                if (j > 0) {
                    if (dp[i - 1][j - 1] != Integer.MAX_VALUE && dp[i - 1][j - 1] + triangle.get(i).get(j) < dp[i][j]) {
                        dp[i][j] = dp[i - 1][j - 1] + triangle.get(i).get(j);
                    }
                }
            }
        }
        return Arrays.stream(dp[m - 1]).min().getAsInt();
    }
}