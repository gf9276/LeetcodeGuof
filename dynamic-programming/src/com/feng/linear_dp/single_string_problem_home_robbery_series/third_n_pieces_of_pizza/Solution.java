package com.feng.linear_dp.single_string_problem_home_robbery_series.third_n_pieces_of_pizza;

import java.util.Arrays;

class Solution {
    public int maxSizeSlices(int[] slices) {
        int output;
        int[] slices2 = Arrays.copyOf(slices, slices.length);
        slices2[0] = Integer.MIN_VALUE;
        output = Math.max(rob(Arrays.copyOfRange(slices, 2, slices.length - 1)) + slices[0], rob(slices2));
        return output;
    }

    public int rob(int[] nums) {
        int output = 0;
        int n = nums.length;
        int totalNbr = n / 3;
        int[][] dp = new int[n + 1][totalNbr + 1];

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < Math.min(totalNbr + 1, i + 1); j++) {
                dp[i][j] = Math.max(dp[i - 1][j], (i - 2 >= 0 ? dp[i - 2][j - 1] : 0) + nums[i - 1]);
                output = Math.max(dp[i][j], output);
            }
        }
        return output;
    }

}