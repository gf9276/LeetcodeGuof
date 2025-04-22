package com.guof.classical_linear_dp.lis.lc_2826;

import java.util.Arrays;
import java.util.List;

class Solution {
    public int minimumOperations(List<Integer> nums) {
        // 就是找最长
        return nums.size() - lengthOfLIS(nums.toArray(new Integer[0]));
    }

    public int lengthOfLIS(Integer[] nums) {
        // 找到最长得递增子序列
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] >= nums[i]) {
                    dp[j] = Math.max(dp[j], dp[i] + 1);
                }
            }
        }
        return Arrays.stream(dp).max().getAsInt();
    }
}