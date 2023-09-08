package com.feng.more_practice.finding_the_minimum_value_in_a_rotated_sorted_array;


class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = (right - left) / 2 + left;

            if (nums[mid] < nums[right]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        if (left == nums.length) return nums[0];
        return nums[left];
    }
}