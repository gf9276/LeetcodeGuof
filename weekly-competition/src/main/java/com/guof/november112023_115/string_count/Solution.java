package com.guof.november112023_115.string_count;


class Solution {
    public int stringCount(int n) {
        int mod = 1000000007;
        // "", l, e, t, le, lt, ee, et, lee, let, eet, leet
        // 一共十种可能，然后n是10的5次，空间应该是可以的
        if (n < 4) {
            return 0;
        }
        long[][] dp = new long[n + 1][12]; // 前n个，仅满足上面情况的例子
        dp[0][0] = 1;
        for (int i = 1; i < dp.length; i++) {
            dp[i][0] = (dp[i - 1][0] * 23) % mod;
            dp[i][1] = (dp[i - 1][1] * 24 + dp[i - 1][0]) % mod; // 多吃一个字符。。。
            dp[i][2] = (dp[i - 1][2] * 23 + dp[i - 1][0]) % mod;
            dp[i][3] = (dp[i - 1][3] * 24 + dp[i - 1][0]) % mod;
            dp[i][4] = (dp[i - 1][4] * 24 + (dp[i - 1][1] + dp[i - 1][2])) % mod; // 前面有一个l或者一个e
            dp[i][5] = (dp[i - 1][5] * 25 + (dp[i - 1][1] + dp[i - 1][3])) % mod;
            dp[i][6] = (dp[i - 1][6] * 24 + dp[i - 1][2]) % mod;
            dp[i][7] = (dp[i - 1][7] * 24 + (dp[i - 1][2] + dp[i - 1][3])) % mod;
            dp[i][8] = (dp[i - 1][8] * 25 + (dp[i - 1][4] + dp[i - 1][6])) % mod;
            dp[i][9] = (dp[i - 1][9] * 25 + (dp[i - 1][4] + dp[i - 1][5] + dp[i - 1][7])) % mod;
            dp[i][10] = (dp[i - 1][10] * 25 + (dp[i - 1][6] + dp[i - 1][7])) % mod;
            dp[i][11] = (dp[i - 1][11] * 26 + (dp[i - 1][8] + dp[i - 1][9] + dp[i - 1][10])) % mod;
        }
        return (int) dp[n][11];
    }
}