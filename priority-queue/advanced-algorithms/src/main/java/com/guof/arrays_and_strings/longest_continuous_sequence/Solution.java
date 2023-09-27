package com.guof.arrays_and_strings.longest_continuous_sequence;

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
    public int longestConsecutive(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        Arrays.sort(nums);
        int curLen = 1;
        int output = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1] + 1) {
                curLen++;
                output = Math.max(output, curLen);
            } else if (nums[i] == nums[i - 1]) {
                continue;
            } else {
                curLen = 1;
            }
        }
        return output;
    }
}