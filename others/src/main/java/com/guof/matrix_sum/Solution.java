package com.guof.matrix_sum;


import java.util.Arrays;

class Solution {
    public int matrixSum(int[][] nums) {
        // 先行排序，再列排序
        for (int[] num : nums) {
            Arrays.sort(num); // 升序
        }

        int output = 0;
        // 接下来找每一列的最大值
        for (int j = 0; j < nums[0].length; j++) {
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < nums.length; i++) {
                max = Math.max(nums[i][j], max);
            }
            output += max;
        }
        return output;
    }
}