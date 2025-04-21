package com.guof.start_dp.maximum_subarray_sum.lc_53;


// leetcode 198
// 打家劫舍

class Solution {
    public int maxSubArray(int[] nums) {
        int ans = nums[0];
        int curNbr = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            curNbr = Math.max(curNbr + num, num);
            ans = Math.max(ans, curNbr);
        }
        return ans;
    }
}