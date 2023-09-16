package com.feng.linear_dp.single_string_problem_other_single_string_dpi_problems.division_of_arithmetic_sequence;

class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int[] dp = new int[nums.length];

        for (int i = 2; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
                dp[i] = dp[i - 1] + 1;

            } else {
                dp[i] = 0;
            }
        }

        int output = 0;
        for (int i = 2; i < dp.length; i++) {
//            if (i + 1 == dp.length || dp[i + 1] == 0) {
            output += dp[i];
//            }
        }
        return output;

    }
}