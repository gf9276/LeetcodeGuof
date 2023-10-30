package com.guof.october282023_116.length_of_longest_subsequence;


import java.util.Arrays;
import java.util.List;

class Solution {

    // 还是dfs加上减枝吧
    public int lengthOfLongestSubsequence(List<Integer> nums, int target) {
        int[][] dp = new int[nums.size() + 1][target + 1]; // 用了前i个数字，和为target的最大长度
        for (int[] ints : dp) {
            Arrays.fill(ints, Integer.MIN_VALUE);
        }
        for (int i = 0; i < dp.length; i++) {
            // 和为0，长度肯定是0。。。
            dp[i][0] = 0;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j - nums.get(i - 1) >= 0) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - nums.get(i - 1)] + 1);
                }
            }
        }
        int output = dp[nums.size()][target];
        return output < 0 ? -1 : output;
    }
}