package com.guof.start_dp.maximum_subarray_sum.lc_2321;


// leetcode 2321

class Solution {
    public int maximumsSplicedArray(int[] nums1, int[] nums2) {
        return Math.max(getMax(nums1, nums2), getMax(nums2, nums1));
    }

    public int getMax(int[] nums1, int[] nums2) {
        int[] diff = new int[nums1.length];

        for (int i = 0; i < nums1.length; i++) {
            diff[i] = nums2[i] - nums1[i];
        }

        // 要求diff最大
        int maxAns = Integer.MIN_VALUE;
        int curNbr = 0;
        int sum = 0;
        for (int i = 0; i < nums1.length; i++) {
            curNbr = Math.max(curNbr + diff[i], diff[i]);
            maxAns = Math.max(curNbr, maxAns);
            sum += nums1[i];
        }
        return sum + maxAns;
    }
}

