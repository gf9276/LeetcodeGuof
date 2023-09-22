package com.guof.linear_dp.double_string_problem_other_dij.different_subsequences;

class Solution {
    public int numDistinct(String s, String t) {
        if (s.equals(t)) {
            return 1;
        }


        int[][] dp = new int[s.length() + 1][t.length() + 1];

        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < Math.min(i + 1, dp[i].length); j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - 1]; // 至少是这个数
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[s.length()][t.length()];
    }
}