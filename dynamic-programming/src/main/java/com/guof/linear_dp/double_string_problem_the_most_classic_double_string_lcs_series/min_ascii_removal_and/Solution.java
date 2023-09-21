package com.guof.linear_dp.double_string_problem_the_most_classic_double_string_lcs_series.min_ascii_removal_and;

class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        // 不就是加权最大lcs？
        int[][] dp = new int[s1.length()][s2.length()];

        for (int i = 0; i < s1.length(); i++) {
            for (int j = 0; j < s2.length(); j++) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    dp[i][j] = i - 1 >= 0 && j - 1 >= 0 ? dp[i - 1][j - 1] + s1.charAt(i) : s1.charAt(i);
                } else {
                    dp[i][j] = Math.max(i - 1 >= 0 ? dp[i - 1][j] : 0, j - 1 >= 0 ? dp[i][j - 1] : 0);
                }
            }
        }
        int sum = 0;
        for (char c : s1.toCharArray()) {
            sum += c;
        }
        for (char c : s2.toCharArray()) {
            sum += c;
        }
        sum -= 2 * dp[s1.length() - 1][s2.length() - 1];

        return sum;
    }
}