package com.guof.start_dp.climb_stairs.lc_2466;


// leetcode 2466

import java.lang.reflect.Array;
import java.util.Arrays;

class Solution {
    public int countGoodStrings(int low, int high, int zero, int one) {
        // 统计每种长度下，字符串的个数
        Long[] dp = new Long[high + 1];
        Arrays.fill(dp, 0L);
        dp[0] = 1L; // 长度为0的串有一个
        for (int i = 1; i < dp.length; i++) {
            // 开始统计串的数量
            if (i - zero >= 0) {
                dp[i] = (dp[i] + dp[i - zero]) % 1000000007;
            }
            if (i - one >= 0) {
                dp[i] = (dp[i] + dp[i - one]) % 1000000007;
            }
        }
        long ans = 0L;
        for (int i = low; i <= high; i++) {
            ans = (ans + dp[i]) % 1000000007;
        }
        return (int) ans;
    }
}