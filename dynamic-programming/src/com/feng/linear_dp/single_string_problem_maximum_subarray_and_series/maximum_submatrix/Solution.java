package com.feng.linear_dp.single_string_problem_maximum_subarray_and_series.maximum_submatrix;

class Solution {
    public int[] getMaxMatrix(int[][] matrix) {
        int[] output = new int[4];
        int max = matrix[0][0];
        for (int i = 0; i < matrix.length; i++) {
            int[] nums = new int[matrix[0].length];
            // 按照行
            for (int j = i; j < matrix.length; j++) {
                for (int k = 0; k < matrix[0].length; k++) {
                    nums[k] += matrix[j][k];
                }
                int[] cur1dCoord = maxSubArray(nums); // 坐标和值
                if (cur1dCoord[2] > max)
                {
                    max = cur1dCoord[2];
                    output[0] = i;
                    output[1] = cur1dCoord[0];
                    output[2] = j;
                    output[3] = cur1dCoord[1];
                }
            }
        }
        return output;
    }

    public int[] maxSubArray(int[] nums) {
        // 当前最大和为上一个和+当前值?当前值

        int[][] coord = new int[nums.length][2]; // 初始就是0
        int[] dp = new int[nums.length];

        dp[0] = nums[0];
        int output = nums[0];
        int[] outputCoord = new int[3];

        for (int i = 1; i < nums.length; i++) {
            if (dp[i - 1] + nums[i] > nums[i]) {
                coord[i][0] = coord[i - 1][0];
                coord[i][1] = i;
                dp[i] = dp[i - 1] + nums[i];
            } else {
                coord[i][0] = i;
                coord[i][1] = i;
                dp[i] = nums[i];
            }

            if (dp[i] > output) {
                output = dp[i];
                outputCoord[0] = coord[i][0];
                outputCoord[1] = coord[i][1];
                outputCoord[2] = output;
            }
        }

        return outputCoord;
    }
}