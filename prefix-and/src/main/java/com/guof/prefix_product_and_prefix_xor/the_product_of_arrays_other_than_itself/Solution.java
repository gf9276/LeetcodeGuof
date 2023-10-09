package com.guof.prefix_product_and_prefix_xor.the_product_of_arrays_other_than_itself;

import java.util.Arrays;

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] output = new int[nums.length];
        Arrays.fill(output, 1);

        for (int i = 1; i < nums.length; i++) {
            // 左侧积
            output[i] = output[i - 1] * nums[i - 1];
        }

        int Right = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            Right *= nums[i + 1];
            output[i] = output[i] * Right;
        }

        return output;
    }
}