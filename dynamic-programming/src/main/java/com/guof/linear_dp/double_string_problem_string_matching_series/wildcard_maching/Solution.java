package com.guof.linear_dp.double_string_problem_string_matching_series.wildcard_maching;

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
            // 如果是无敌的通配符，直接找到相等的地方，然后把后面的直接都给变成true就好了
            if (p.charAt(i - 1) == '*') {
                // 狂true到底
                for (int j = 0; j < s.length() + 1; j++) {
                    if (dp[i - 1][j]) {
                        for (int k = j; k < s.length() + 1; k++) {
                            dp[i][k] = true;
                        }
                        break;
                    }
                }
                continue;
            }
            // 如果没有无敌的通配符，那就逐字符匹配
            for (int j = 1; j < s.length() + 1; j++) {
                if (p.charAt(i - 1) == '?' || p.charAt(i - 1) == s.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                }
            }
        }
        return dp[p.length()][s.length()];
    }
}