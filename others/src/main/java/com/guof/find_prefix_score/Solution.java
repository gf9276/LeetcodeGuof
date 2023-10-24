package com.guof.find_prefix_score;


class Solution {
    public long[] findPrefixScore(int[] nums) {
        long[] output = new long[nums.length];
        int max = Integer.MIN_VALUE;


        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
            output[i] = max + nums[i];
        }

        for (int i = 1; i < nums.length; i++) {
            output[i] += output[i - 1];
        }

        return output;
    }
}