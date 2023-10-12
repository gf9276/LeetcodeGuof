package com.guof.linear_dp.backpack_dp.segmentation_and_subset;

class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        if (sum % 2 == 1) {
            return false; // 奇数不可分
        }

        int target = sum / 2;

        // 前 n 个 恰好为target的 boolean
        boolean[][] dp = new boolean[nums.length + 1][target + 1];

        // 初始化，前n个肯定可以等于0，不拿就好了
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = true;
        }
        // 拿一个这些肯定都是true的
        for (int num : nums) {
            if (num <= target) {
                dp[1][num] = true;
                break;
            }
        }

        for (int i = 2; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j - nums[i - 1] >= 0) {
                    dp[i][j] |= dp[i - 1][j - nums[i - 1]];
                }
            }
        }

        return dp[nums.length][target];
    }
}