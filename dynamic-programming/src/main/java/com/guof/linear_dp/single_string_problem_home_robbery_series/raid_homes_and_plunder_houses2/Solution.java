package com.guof.linear_dp.single_string_problem_home_robbery_series.raid_homes_and_plunder_houses2;

class Solution {
    public int rob(int[] nums) {
        if (nums.length <= 1) {
            return nums[0];
        }
        // 分两种情况就好了

        // 必须偷第一家
        int output;
        int[][] dp = new int[nums.length][2];

        dp[1][0] = nums[0];
        dp[1][1] = nums[0];
        output = nums[0];

        // 最后一家就不能偷了
        for (int i = 2; i < nums.length - 1; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            dp[i][1] = dp[i - 1][0] + nums[i];
            output = Math.max(dp[i][0], output);
            output = Math.max(dp[i][1], output);
        }

        // 第一家不能偷
        dp[1][0] = 0;
        dp[1][1] = nums[1];
        output = Math.max(output, nums[1]);

        // 最后一家想偷就偷
        for (int i = 2; i < nums.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            dp[i][1] = dp[i - 1][0] + nums[i];
            output = Math.max(dp[i][0], output);
            output = Math.max(dp[i][1], output);
        }

        return output;
    }
}