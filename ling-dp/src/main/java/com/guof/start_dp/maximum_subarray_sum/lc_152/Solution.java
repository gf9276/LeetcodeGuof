package com.guof.start_dp.maximum_subarray_sum.lc_152;

class Solution {
    public int maxProduct(int[] nums) {
        // 乘机可以最大，也可以最小
        int minAns = nums[0];
        int maxAns = nums[0];
        int minCurNbr = nums[0];
        int maxCurNbr = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int tmp = minCurNbr;

            minCurNbr = Math.min(nums[i], nums[i] * minCurNbr);
            minCurNbr = Math.min(minCurNbr, nums[i] * maxCurNbr);

            maxCurNbr = Math.max(nums[i], nums[i] * maxCurNbr);
            maxCurNbr = Math.max(maxCurNbr, nums[i] * tmp);

            minAns = Math.min(minAns, minCurNbr);
            maxAns = Math.max(maxAns, maxCurNbr);
        }

        return maxAns;
    }
}