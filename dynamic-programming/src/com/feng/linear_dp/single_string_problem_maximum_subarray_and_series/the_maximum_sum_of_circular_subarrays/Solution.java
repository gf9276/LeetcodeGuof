package com.feng.linear_dp.single_string_problem_maximum_subarray_and_series.the_maximum_sum_of_circular_subarrays;

class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int[] dpMax = new int[nums.length];
        dpMax[0] = nums[0];
        int[] dpMin = new int[nums.length];
        dpMin[0] = nums[0];
        int max = nums[0];
        int min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dpMax[i] = Math.max(nums[i], nums[i] + dpMax[i - 1]);
            max = Math.max(max, dpMax[i]);

            dpMin[i] = Math.min(nums[i], nums[i] + dpMin[i - 1]);
            min = Math.min(min, dpMin[i]);
        }
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        return min == sum ? max : Math.max(sum - min, max);
    }
}