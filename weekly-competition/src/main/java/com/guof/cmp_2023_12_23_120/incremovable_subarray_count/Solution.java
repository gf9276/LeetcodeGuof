package com.guof.cmp_2023_12_23_120.incremovable_subarray_count;

class Solution {
    public long incremovableSubarrayCount(int[] nums) {
        // 找到最大递增子数组长度，找到末尾idx即可
        int firstIdx = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                firstIdx = i;
            } else {
                break;
            }
        }

        int lastIdx = nums.length - 1; // 从末尾到开头
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                lastIdx = i;
            } else {
                break;
            }
        }

        long output = 0;

        // 太好了，有序的
        if (firstIdx == nums.length - 1 && lastIdx == 0) {
            return nums.length * (1L + nums.length) / 2;
        }


        output += nums.length - lastIdx + 1;
        for (int i = 0, j = lastIdx; i <= firstIdx; i++) {
            while (j < nums.length && nums[j] <= nums[i]) {
                j++;
            }
            output += nums.length - j + 1;// 这是必删的
        }
        return output;
    }
}