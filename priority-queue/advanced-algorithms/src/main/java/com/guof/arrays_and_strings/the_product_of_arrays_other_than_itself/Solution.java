package com.guof.arrays_and_strings.the_product_of_arrays_other_than_itself;

import java.util.Arrays;

/**
 * ClassName: Solution
 * Package: com.feng.dynamic_programming.climb_stairs
 * Description:
 *
 * @Author guof
 * @Create 2023/3/27 22:23
 * @Version 1.0
 */
class Solution {
    public int[] productExceptSelf(int[] nums) {
        // 交替着相乘，不是有手就行？
        int[] output = new int[nums.length];
        Arrays.fill(output, 1);
        int mul1 = 1;
        int mul2 = 1;

        for (int i = 0; i < nums.length; i++) {
            if (i > 0) {
                mul1 *= nums[i - 1];
                output[i] *= mul1;
            }
            if (i < nums.length - 1) {
                mul2 *= nums[nums.length - 1 - i];
                output[nums.length - 2 - i] *= mul2;
            }
        }
        return output;
    }
}