package com.guof.linear_dp.double_string_problem_the_most_classic_double_string_lcs_series.lcs;

class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length()][text2.length()];

        for (int i = 0; i < text1.length(); i++) {
            for (int j = 0; j < text2.length(); j++) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    dp[i][j] = i - 1 >= 0 && j - 1 >= 0 ? dp[i - 1][j - 1] + 1 : 1;
                } else {
                    dp[i][j] = Math.max(i - 1 >= 0 ? dp[i - 1][j] : 0, j - 1 >= 0 ? dp[i][j - 1] : 0);
                }
            }
        }
        return dp[text1.length() - 1][text2.length() - 1];
    }
}