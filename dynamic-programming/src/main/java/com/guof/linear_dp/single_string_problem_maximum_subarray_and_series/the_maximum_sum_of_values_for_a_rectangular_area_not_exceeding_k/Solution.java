package com.guof.linear_dp.single_string_problem_maximum_subarray_and_series.the_maximum_sum_of_values_for_a_rectangular_area_not_exceeding_k;

class Solution {
    public int maxSumSubmatrix(int[][] matrix, int h) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < matrix.length; i++) {
            int[] nums = new int[matrix[0].length];
            // 按照行
            for (int j = i; j < matrix.length; j++) {
                for (int k = 0; k < matrix[0].length; k++) {
                    nums[k] += matrix[j][k];
                }
                max = Math.max(maxSubArray(nums, h), max);
            }
        }
        return max;
    }

    public int maxSubArray(int[] nums, int k) {
        // 当前最大和为上一个和+当前值?当前值

        int output = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int curSum = 0;
            for (int j = i; j < nums.length; j++) {
                curSum += nums[j];
                if (curSum <= k && curSum > output) {
                    output = curSum;
                }
            }
        }

        return output;
    }
}