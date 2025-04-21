package com.guof.grid_dp.basic.lc_120;

import java.util.Arrays;
import java.util.List;

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        // 只能向下或者向右侧
        int m = triangle.size();
        int n = triangle.get(m - 1).size();
        int[][] dp = new int[m][n];
        dp[0][0] = triangle.get(0).get(0);

        for (int i = 1; i < triangle.size(); i++) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                dp[i][j] = Math.min(j <= i - 1 ? dp[i - 1][j] : Integer.MAX_VALUE, j - 1 >= 0 ? dp[i - 1][j - 1] : Integer.MAX_VALUE) + triangle.get(i).get(j);
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            ans = Math.min(ans, dp[m - 1][i]);
        }
        return ans;
    }
}