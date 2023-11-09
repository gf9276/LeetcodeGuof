package com.guof.three_sum_closest;

import java.util.Arrays;

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        // 去二存一
        Arrays.sort(nums); // 从小到大排列
        int output = nums[0] + nums[1] + nums[2];
        int minDist = Integer.MAX_VALUE;

        for (int i = 0; i <= nums.length - 3; i++) {
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                if (nums[i] + nums[left] + nums[right] == target) {
                    return target;
                }

                if (Math.abs(nums[i] + nums[left] + nums[right] - target) < minDist) {
                    minDist = Math.abs(nums[i] + nums[left] + nums[right] - target);
                    output = nums[i] + nums[left] + nums[right];
                }

                if (nums[i] + nums[left] + nums[right] > target) {
                    right--;
                } else if (nums[i] + nums[left] + nums[right] < target) {
                    left++;
                }
            }
        }
        return output;
    }
}