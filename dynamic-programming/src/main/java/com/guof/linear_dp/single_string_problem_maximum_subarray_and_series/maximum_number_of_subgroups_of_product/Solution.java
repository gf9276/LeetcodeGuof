package com.guof.linear_dp.single_string_problem_maximum_subarray_and_series.maximum_number_of_subgroups_of_product;

class Solution {
    public int maxProduct(int[] nums) {
        int[] dpMax = new int[nums.length];
        int[] dpMin = new int[nums.length];

        dpMax[0] = nums[0];
        dpMin[0] = nums[0];

        int output = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < 0) {
                dpMax[i] = Math.max(nums[i], dpMin[i - 1] * nums[i]);
                dpMin[i] = Math.min(nums[i], dpMax[i - 1] * nums[i]);
            } else if (nums[i] > 0) {
                dpMax[i] = Math.max(nums[i], dpMax[i - 1] * nums[i]);
                dpMin[i] = Math.min(nums[i], dpMin[i - 1] * nums[i]);
            } else {
                dpMax[i] = 0;
                dpMin[i] = 0;
            }

            output = Math.max(output, dpMax[i]);
        }

        return output;

    }
}