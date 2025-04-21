package com.guof.start_dp.climb_stairs.lc_2266;


// leetcode 2266

class Solution {
    public int countTexts(String pressedKeys) {
        // 几种可能性
        // 最多连续字母是3个，除了7和9
        long[] dp = new long[pressedKeys.length() + 1];
        dp[0] = 1; // 啥都灭有也是一种可能性

        for (int i = 1; i < dp.length; i++) {
            int continuesNbr = pressedKeys.charAt(i - 1) == '7' || pressedKeys.charAt(i - 1) == '9' ? 4 : 3;
            int j = i - 1;
            for (; j - 1 >= 0 && pressedKeys.charAt(j - 1) == pressedKeys.charAt(i - 1); j--) {
                if (i - j + 1 > continuesNbr) {
                    break;
                }
                dp[i] = (dp[i] + dp[j]) % 1000000007;
            }
            if (j >= 0) {
                dp[i] = (dp[i] + dp[j]) % 1000000007;
            }
        }
        return (int) (dp[dp.length - 1] % 1000000007);
    }
}