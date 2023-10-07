package com.guof.prefix_sum_and_suffix_sum.find_the_central_index_of_an_array;

class Solution {
    public int pivotIndex(int[] nums) {
        int[] dpLeft = new int[nums.length];
        int[] dpRight = new int[nums.length];

        for (int i = 1; i < nums.length; i++) {
            dpLeft[i] = dpLeft[i - 1] + nums[i - 1];
        }
        for (int i = nums.length - 2; i >= 0; i--) {
            dpRight[i] = dpRight[i + 1] + nums[i + 1];
        }

        int left = 0;
        int right = nums.length - 1;

        for (int i = 0; i < dpRight.length; i++) {
            if (dpRight[i] == dpLeft[i]) {
                return i;
            }
        }
        return -1;
    }
}