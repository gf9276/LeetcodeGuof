package com.guof.prefix_sum_and_monotonic_stack_monotonic_queue.max_sum_min_product;

class Solution {
    public int maxSumMinProduct(int[] nums) {
        // 这题不允许排序，怪不得要用单调栈
        // 和以前的题目一样，找到当前 nums[i] 左右两侧的边界即可

        long[] prefix = new long[nums.length];
        prefix[0] = nums[0];
        for (int i = 1; i < prefix.length; i++) {
            prefix[i] = prefix[i - 1] + nums[i];
        }

        int[] dpLeft = new int[nums.length]; // 左边比他大的下角标
        int[] dpRight = new int[nums.length]; // 右边比他大的边界下角标


        // 0 的左边没有了
        dpLeft[0] = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                dpLeft[i] = i; // 左边相邻没有比他大的
            } else {
                int tmpIdx = dpLeft[i - 1];
                while (tmpIdx >= 0 && nums[i] <= nums[tmpIdx]) {
                    tmpIdx--;
                }
                dpLeft[i] = tmpIdx + 1;
            }
        }

        // 右边没有了
        dpRight[dpRight.length - 1] = dpRight.length - 1;
        for (int i = dpRight.length - 2; i >= 0; i--) {
            if (nums[i] > nums[i + 1]) {
                dpRight[i] = i; // 左边相邻没有比他大的
            } else {
                int tmpIdx = dpRight[i + 1];
                while (tmpIdx < dpRight.length && nums[i] <= nums[tmpIdx]) {
                    tmpIdx++;
                }
                dpRight[i] = tmpIdx - 1;
            }
        }

        long output = 0;

        for (int i = 0; i < nums.length; i++) {
            if (dpLeft[i] == 0) {
                output = Math.max(output, nums[i] * prefix[dpRight[i]]);
            } else {
                output = Math.max(output, nums[i] * (prefix[dpRight[i]] - prefix[dpLeft[i] - 1]));
            }
        }
        return (int) (output % 1000000007);
    }
}