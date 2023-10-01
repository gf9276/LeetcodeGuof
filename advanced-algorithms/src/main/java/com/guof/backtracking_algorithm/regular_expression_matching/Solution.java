package com.guof.backtracking_algorithm.regular_expression_matching;

class Solution {
    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[p.length() + 1][s.length() + 1];

        dp[0][0] = true;

        for (int i = 1; i <= p.length(); i++) {
            for (int j = 0; j <= s.length(); j++) {
                // 使前面一个字符重复 0~n 次的 *
                if (p.charAt(i - 1) == '*' && i - 2 >= 0 && dp[i - 2][j]) {
                    dp[i][j] = true;
                    for (int k = j + 1; k <= s.length(); k++) {
                        if (p.charAt(i - 2) != '.' && s.charAt(k - 1) != p.charAt(i - 2)) {
                            break;
                        } else {
                            dp[i][k] = true;
                        }
                    }
                }
                else if (j > 0 && (p.charAt(i - 1) == '.' || p.charAt(i - 1) == s.charAt(j - 1))) {
                    dp[i][j] = dp[i - 1][j - 1];
                }
            }
        }
        return dp[p.length()][s.length()];
    }
}