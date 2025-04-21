package com.guof.start_dp.robbery.lc_740;


// leetcode 198
// 打家劫舍

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int deleteAndEarn(int[] nums) {
        // 删除1个数字，删除比他小和比他大1的所有数字
        Map<Integer, Integer> map = new HashMap<>();
        int[] nbrs = new int[10001];
        // 统计每个数字的数量
        for (int num : nums) {
            nbrs[num]++;
        }
        int ans = 0;
        int[] dp = new int[10001];
        dp[0] = 0;
        dp[1] = nbrs[1];
        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.max(dp[i - 2] + nbrs[i] * i, dp[i - 1]);
        }
        return dp[dp.length - 1];
    }
}