package com.guof.more_practice3.find_min;

import java.util.Arrays;

class Solution {
    public int findMin(int[] nums) {
        if (nums.length <= 3) {
            Arrays.sort(nums);
            return nums[0];
        }
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = (right - left) / 2 + left;

            if (nums[left] < nums[right]) {
                break;
            }
            if (nums[mid] > nums[left]) {
                if (nums[left] < nums[right]) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            } else {
                right = mid;
            }
        }
        return nums[left];
    }
}