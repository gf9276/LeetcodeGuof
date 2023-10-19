package com.guof.wiggle_max_length;


import java.util.Arrays;

class Solution {
    public int wiggleMaxLength(int[] nums) {
        if (nums.length == 1) {
            return 1;
        }
        if (nums.length == 2) {
            return nums[0] == nums[1] ? 1 : 2;
        }

        // 用dp吧，dp[i]记录以nums[i]为结尾的摆动序列最大长度
        int[] dp = new int[nums.length];

        dp[0] = 1;
        dp[1] = nums[0] == nums[1] ? 1 : 2;

        for (int i = 2; i < nums.length; i++) {
            dp[i] = nums[i] == nums[i - 1] ? 1 : 2; // 最次也是这个水平的
            for (int j = 1; j < i; j++) {
                if (dp[i] >= dp[j] + 1) {
                    // 如果以j结果的最大摆动数组长度加上一个数字，不如当前摆动数组的长度，就直接跳过
                    continue;
                }

                int diff1 = nums[j] - nums[j - 1];
                int diff2 = nums[i] - nums[j]; // 删除i和j之间所有数字

                // 判断是否满足摆动数组的条件，如果满足，就覆盖原来的值
                if (diff1 > 0 && diff2 < 0 || diff1 < 0 && diff2 > 0) {
                    dp[i] = dp[j] + 1;
                }
            }
        }
        return Arrays.stream(dp).max().getAsInt();
    }
}