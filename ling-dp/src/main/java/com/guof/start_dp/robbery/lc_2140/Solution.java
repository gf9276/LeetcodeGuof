package com.guof.start_dp.robbery.lc_2140;


// leetcode 2320
// 打家劫舍

class Solution {
    public long mostPoints(int[][] questions) {
        // 像是青蛙跳
        // 是否解决当前问题即可
        long[] dp = new long[questions.length + 1];
        for (int i = questions.length - 1; i >= 0; i--) {
            int j = Math.min(questions.length, questions[i][1] + i + 1);
            dp[i] = Math.max(dp[j] + questions[i][0], dp[i + 1]);
        }
        return dp[0];
    }
}