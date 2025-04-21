package com.guof.start_dp.maximum_subarray_sum.lc_1749;


// leetcode 198
// 打家劫舍

class Solution {
    public int maxAbsoluteSum(int[] nums) {
        // 是不是直接计算 证书最大 和 负数最大就行了
        int maxAns = nums[0];
        int minAns = nums[0];

        int curNbrMax = nums[0];
        int curNbrMin = nums[0];

        for (int i = 1; i < nums.length; i++) {
            curNbrMax = Math.max(curNbrMax + nums[i], nums[i]);
            maxAns = Math.max(maxAns, curNbrMax);
            curNbrMin = Math.min(curNbrMin + nums[i], nums[i]);
            minAns = Math.min(minAns, curNbrMin);
        }
        return Math.max(maxAns, -minAns);
    }
}