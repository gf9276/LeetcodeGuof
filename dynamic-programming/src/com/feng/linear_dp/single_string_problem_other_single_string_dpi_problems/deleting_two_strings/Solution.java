package com.feng.linear_dp.single_string_problem_other_single_string_dpi_problems.deleting_two_strings;

class Solution {
    public int minDistance(String word1, String word2) {
        if (word1.equals(word2)) {
            return 0;
        }

        int output = 0;
        // 寻找两个word的最长公共子序列, dp[i][j]表示word1，前i个和word2 前j个的最长公共子序列
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];

        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return word1.length() + word2.length() - 2 * dp[word1.length()][word2.length()];
    }
}