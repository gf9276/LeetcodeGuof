package com.feng.linear_dp.single_string_problem_other_single_string_dpi_problems.split_palindrome_string2;

class Solution {
    public int minCut(String s) {
        if (s == null || s.length() == 0 || s.length() == 1) {
            return 0;
        }
        int length = s.length();
        char[] sc = s.toCharArray();

        // 检测所有字串是否为回文
        boolean[][] dp = new boolean[length][length];

        // 顺序很重要
        for (int right = 1; right < s.length(); right++) {
            for (int left = 0; left <= right; left++) {
                if (s.charAt(left) != s.charAt(right)) {
                    // 两者不相等，直接滚
                    continue;
                }
                if (right - left <= 2) {
                    dp[left][right] = true;
                } else {
                    dp[left][right] = dp[left + 1][right - 1];
                }
            }
        }
        int[] dp2 = new int[length];
        for (int i = 1; i < length; i++) {
            if (dp[0][i]) {
                // 无需切割
                dp2[i] = 0;
            } else {
                // 需要切割
                dp2[i] = i; //这是需要切割的最大次数
                for (int j = 1; j <= i; j++) {
                    if (dp[j][i]) {
                        dp2[i] = Math.min(dp2[i], dp2[j - 1] + 1);
                    }
                }
            }
        }
        return dp2[length - 1];
    }
}