package com.guof.cmp_2023_12_23_120.largest_perimeter;

import java.util.Arrays;

class Solution {
    public long largestPerimeter(int[] nums) {
        long output = -1;
        long sum;
        Arrays.sort(nums); // 从小到大排列
        sum = nums[0] + nums[1];
        for (int i = 2; i < nums.length; i++) {
            if (sum > nums[i]) {
                // 成多边形
                output = Math.max(output, sum + nums[i]);
            }
            sum += nums[i]; // 添加边长
        }
        return output;
    }
}