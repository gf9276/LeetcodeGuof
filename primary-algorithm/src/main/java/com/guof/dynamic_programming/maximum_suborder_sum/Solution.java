package com.guof.dynamic_programming.maximum_suborder_sum;

/**
 * ClassName: Solution
 * Package: com.feng.dynamic_programming.maximum_suborder_sum
 * Description:
 *
 * @Author guof
 * @Create 2023/3/30 19:26
 * @Version 1.0
 */
class Solution {
    public int maxSubArray(int[] nums) {
        // 初始版
//        int max_sum = nums[0];  // 开局的最大和
//        int[][] dp = new int[nums.length][2]; // 0表示从头开始，1表示承接上次
//        dp[0][0] = 0;
//        dp[0][1] = nums[0];
//
//
//        for (int i = 1; i < nums.length; i++) {
//            dp[i][0] = nums[i];
//            dp[i][1] = Math.max(nums[i] + dp[i - 1][0], nums[i] + dp[i - 1][1]);
//            max_sum = Math.max(max_sum, Math.max(dp[i][0], dp[i][1]));
//        }
//
//        return max_sum;
        // 进化版
        int max_sum = nums[0]; // 记录整体最大值
        int dp = nums[0]; // 表示第i个回合的最大值
        for (int i = 1; i < nums.length; i++) {
            dp = Math.max(nums[i], nums[i] + dp); // 要么选取当前值重开，要么累加上一个值
            max_sum = Math.max(max_sum, dp); // 挑连续的、重开的，以及自己中最大的那个
        }
        return max_sum;
    }
}