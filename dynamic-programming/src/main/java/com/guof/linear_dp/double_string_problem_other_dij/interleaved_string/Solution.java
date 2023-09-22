package com.guof.linear_dp.double_string_problem_other_dij.interleaved_string;

class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s3.length() != s1.length() + s2.length()) {
            return false;
        }
        boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];

        dp[0][0] = true;

        for (int i = 1; i < Math.min(s3.length(), s2.length()) + 1; i++) {
            if (s3.charAt(i - 1) == s2.charAt(i - 1)) {
                dp[0][i] = true;
            } else {
                break;
            }
        }

        for (int i = 1; i < Math.min(s3.length(), s1.length()) + 1; i++) {
            if (s3.charAt(i - 1) == s1.charAt(i - 1)) {
                dp[i][0] = true;
            } else {
                break;
            }
        }

        for (int i = 1; i < s1.length() + 1; i++) {
            for (int j = 1; j < s2.length() + 1; j++) {
                int s3Idx = i + j - 1;
                if (s2.charAt(j - 1) == s3.charAt(s3Idx)) {
                    dp[i][j] |= dp[i][j - 1];
                }
                if (s1.charAt(i - 1) == s3.charAt(s3Idx)) {
                    dp[i][j] |= dp[i - 1][j];
                }
            }
        }
        return dp[s1.length()][s2.length()];
    }
}