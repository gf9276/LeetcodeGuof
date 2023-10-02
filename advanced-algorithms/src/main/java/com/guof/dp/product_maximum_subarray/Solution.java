package com.guof.dp.product_maximum_subarray;

import java.util.Arrays;

class Solution {
    public int maxProduct(int[] nums) {
        int[][] dp = new int[nums.length][2]; // 0是最大值，1是最小值
        dp[0][0] = nums[0];
        dp[0][1] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int[] tmp = {nums[i], nums[i] * dp[i - 1][0], nums[i] * dp[i - 1][1]};
            Arrays.sort(tmp);
            dp[i][0] = tmp[2];
            dp[i][1] = tmp[0];
        }

        int output = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (dp[i][0] > output) {
                output = dp[i][0];
            }
        }

        return output;
    }
}