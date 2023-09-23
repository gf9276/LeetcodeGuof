package com.guof.linear_dp.double_string_problem_dimensioned_dijk.scramble_string;

class Solution {
    public boolean isScramble(String s1, String s2) {
        int length = s1.length();
        boolean[][][] dp = new boolean[length][length][length + 1];

        // 长度为一，判断是否相等
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                dp[i][j][0] = true;
                dp[i][j][1] = (s1.charAt(i) == s2.charAt(j));
            }
        }

        // 开始枚举，判断 dp[i][j][len]是不是和谐的
        for (int len = 2; len <= length; len++) {
            for (int i = 0; i < length - len + 1; i++) {
                for (int j = 0; j < length - len + 1; j++) {
                    for (int k = 1; k <= len - 1; k++) {
                        // k是划分点
                        // 两种情况
                        // 情况一，不交换位置，直接全部都和谐
                        // 情况二，交换位置，交叉和谐
                        // 直接用if比或+与运算还要快？
                        if (dp[i][j][k] && dp[i + k][j + k][len - k]) {
                            dp[i][j][len] = true;
                            break;
                        }
                        if (dp[i][j + len - k][k] && dp[i + k][j][len - k]) {
                            dp[i][j][len] = true;
                            break;
                        }
                    }
                }
            }

        }
        return dp[0][0][length];
    }
}