package com.feng.dynamic_programming.longest_increasing_subsequence;

import java.util.Arrays;

/**
 * ClassName: Solution
 * Package: com.feng.dynamic_programming.longest_increasing_subsequence
 * Description:
 *
 * @Author guof
 * @Create 2023/4/23 17:49
 * @Version 1.0
 */
class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 1) {
            return 1;
        }

        int max_length = 1;
        int[] dp = new int[nums.length]; // 长度
        Arrays.fill(dp, 1); // 默认都是1

        for (int i = 1; i < nums.length; i++) {
            for (int j = 1; j <= i; j++) {
                if (nums[i] > nums[i - j]) {
                    dp[i] = Math.max(dp[i], dp[i - j] + 1);
                    max_length = Math.max(max_length, dp[i]);
                }
            }

        }

        return max_length;
    }
}
