package com.guof.linear_dp.double_string_problem_string_matching_series.edit_distance;

class Solution {
    public int minDistance(String word1, String word2) {
        if (word1.isEmpty()) {
            return word2.length();
        }
        if (word2.isEmpty()) {
            return word1.length();
        }

        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i] = i;
        }
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = i;
        }


        for (int i = 1; i < word1.length() + 1; i++) {
            for (int j = 1; j < word2.length() + 1; j++) {
                // 前i+1和j+1个，需要变化次数
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    // 一样说明不需要变化
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    // 不一样挑一个变化次数少的
                    int tmp = Math.min(dp[i - 1][j], dp[i][j - 1]);
                    tmp = Math.min(tmp, dp[i - 1][j - 1]);
                    dp[i][j] = tmp + 1;
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }
}