package com.guof.min_cost;


import java.util.Arrays;

class Solution {
    public long minCost(int[] nums, int x) {
        // 好像不用那么复杂啊
        long output = 0;
        int n = nums.length;
        for (int num : nums) {
            output += num;
        }
        int[] curNums = Arrays.copyOf(nums, n);

        for (int i = 1; i < n; i++) {
            long sum = 0;
            for (int j = 0; j < n; j++) {
                curNums[j] = Math.min(curNums[j], nums[(i + j) % n]);
                sum += curNums[j];
            }
            output = Math.min(output, sum + (long) x * i);
        }

        return output;
    }
}