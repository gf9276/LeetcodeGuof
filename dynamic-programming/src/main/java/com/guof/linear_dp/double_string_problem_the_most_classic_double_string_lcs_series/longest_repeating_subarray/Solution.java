package com.guof.linear_dp.double_string_problem_the_most_classic_double_string_lcs_series.longest_repeating_subarray;

class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        int[][] dp = new int[nums1.length][nums2.length];
        int output = 0;

        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    dp[i][j] = (i - 1 >= 0 && j - 1 >= 0) ? dp[i - 1][j - 1] + 1 : 1;
                    output = Math.max(output, dp[i][j]);
                }
            }
        }
        return output;
    }
}