package com.guof.linear_dp.single_string_problem_home_robbery_series.raid_homes_and_plunder_houses;

class Solution {
    public int rob(int[] nums) {
        // 当天赚的钱 前一天不偷+今天，前一天偷了
        int output;
        int[][] dp = new int[nums.length][2];

        dp[0][0] = 0;
        dp[0][1] = nums[0];
        output = nums[0];

        for (int i = 1; i < nums.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            dp[i][1] = dp[i - 1][0] + nums[i];
            output = Math.max(dp[i][0],output);
            output = Math.max(dp[i][1],output);
        }
        return output;
    }
}