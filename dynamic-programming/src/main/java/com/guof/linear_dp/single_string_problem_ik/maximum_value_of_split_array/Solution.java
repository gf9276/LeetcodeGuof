package com.guof.linear_dp.single_string_problem_ik.maximum_value_of_split_array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeMap;

class Solution {
    public int splitArray(int[] nums, int k) {
        // 我知道了，呵呵
        int[][] dp = new int[nums.length][k];
        int sum = 0;
        for (int i = 0; i < dp.length; i++) {
            // 分成一个数组的，直接相加就好了
            sum += nums[i];
            dp[i][0] = sum;
        }

        for (int i = 1; i < nums.length; i++) {
            // 前i+1个数组，分成j+1个数组的最大和的最小值
            // 最大值为i, 因为i+1个数组, 最多分成i+1份嘛
            for (int j = 1; j < Math.min(i + 1, k); j++) {
                dp[i][j] = Integer.MAX_VALUE;
                int curSum = 0;
                for (int l = i - 1; l >= j - 1; l--) {
                    curSum += nums[l + 1];
                    dp[i][j] = Math.min(Math.max(dp[l][j - 1], curSum), dp[i][j]);
                }
            }
        }
        return dp[nums.length - 1][k - 1];
    }
}