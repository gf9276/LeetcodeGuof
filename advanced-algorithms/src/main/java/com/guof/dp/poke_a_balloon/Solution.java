package com.guof.dp.poke_a_balloon;

class Solution {
    public int maxCoins(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        // 头尾各加1，实现开区间最大硬币数计算
        int[][] dp = new int[nums.length + 2][nums.length + 2];
        dp[0][2] = nums[0] * nums[1]; // 0~2区间范围就是第一个硬币

        for (int j = 3; j < nums.length + 2; j++) {
            for (int i = j - 2; i >= 0; i--) {
                int max = Integer.MIN_VALUE;
                for (int k = i + 1; k < j; k++) {
                    max = Math.max(max, dp[i][k] + dp[k][j] + nums[k - 1] * (i - 1 >= 0 ? nums[i - 1] : 1) * (j - 1 <= nums.length - 1 ? nums[j - 1] : 1));
                }
                dp[i][j] = max;
            }
        }
        return dp[0][nums.length + 1];
    }
}