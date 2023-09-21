package com.guof.linear_dp.double_string_problem_string_matching_series.regular_expression_maching;

class Solution {
    public boolean isMatch(String s, String p) {
        if (s.isEmpty() && p.isEmpty()) {
            return true;
        }
        if (p.equals("*")) {
            // 匹配所有
            return true;
        }

        boolean[][] dp = new boolean[p.length() + 1][s.length() + 1];
        dp[0][0] = true;

        for (int i = 1; i < p.length() + 1; i++) {
            // 如果是无敌的通配符，甚至可以扭转乾坤
            if (p.charAt(i - 1) == '*') {
                if (i == 1) {
                    dp[1][0] = true;
                } else {
                    for (int j = 0; j < s.length() + 1; j++) {
                        if (dp[i - 2][j]) {
                            dp[i][j] = true;
                            // 找到启动点了
                            for (int k = j + 1; k < s.length() + 1; k++) {
                                if (s.charAt(k - 1) == p.charAt(i - 2) || p.charAt(i - 2) == '.') {
                                    dp[i][k] = true;
                                } else {
                                    break;
                                }
                            }
                        }

                    }
                }
                continue;
            }
            // 如果没有无敌的通配符，那就逐字符匹配
            for (int j = 1; j < s.length() + 1; j++) {
                if (p.charAt(i - 1) == '.' || p.charAt(i - 1) == s.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                }
            }
        }
        return dp[p.length()][s.length()];
    }
}