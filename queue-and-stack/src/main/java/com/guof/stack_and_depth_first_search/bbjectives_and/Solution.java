package com.guof.stack_and_depth_first_search.bbjectives_and;


class Solution {
    int output = 0;

    public int findTargetSumWays(int[] nums, int target) {
        output = 0;

        int[] nums2 = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            nums2[i] = -nums[i];
        }

        dfs(nums, nums2, 0, 0, target);
        return output;
    }


    public void dfs(int[] nums1, int[] nums2, int nowNbr, int sum, int target) {
        if (nowNbr == nums1.length) {
            if (sum == target) output += 1;
            return;
        }
        nowNbr++;
        dfs(nums1, nums2, nowNbr, sum + nums1[nowNbr - 1], target);
        dfs(nums1, nums2, nowNbr, sum + nums2[nowNbr - 1], target);
    }
}