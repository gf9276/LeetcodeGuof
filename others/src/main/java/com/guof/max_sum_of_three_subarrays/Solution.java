package com.guof.max_sum_of_three_subarrays;


class Solution {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int[][] dp = new int[nums.length - k + 1][3]; // 以 i 为 开头，第n个子序列的最大和
        int[][][] dp2 = new int[nums.length - k + 1][3][3]; // 用来记录输出的索引的

        // 先求一下 0~k-1的和
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        dp[0][0] = sum;
        dp[0][1] = sum;
        dp[0][2] = sum;

        int max1 = 0;
        int max2 = 0;
        int max1Idx = 0;
        int max2Idx = 0;

        for (int i = 1; i < dp.length; i++) {
            sum -= nums[i - 1];
            sum += nums[i + k - 1];

            // 第一个子序列
            dp[i][0] = sum; // 只有你啦
            dp2[i][0] = new int[]{i, 0, 0};

            // 第二个子序列
            if (i - k >= 0) {
                if (dp[i - k][0] > max1) {
                    max1 = dp[i - k][0];
                    max1Idx = i - k;
                }
            }
            dp[i][1] = max1 + sum;
            dp2[i][1] = new int[]{max1Idx, i, 0};

            if (i - k >= 0) {
                if (dp[i - k][1] > max2) {
                    max2 = dp[i - k][1];
                    max2Idx = i - k;
                }
            }
            dp[i][2] = max2 + sum;
            dp2[i][2] = new int[]{dp2[max2Idx][1][0], dp2[max2Idx][1][1], i};
        }

        int outputIdx = 0;
        int maxSum = 0;
        for (int i = 0; i < dp.length; i++) {
            if (dp[i][2] > maxSum) {
                maxSum = dp[i][2];
                outputIdx = i;
            }
        }
        return dp2[outputIdx][2];
    }
}