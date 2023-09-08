package com.feng.template2.finding_the_minimum_value_in_a_rotated_sorted_array;

class Solution {
    public int findMin(int[] nums) {
        // 这不是有手就行？
        if (nums[0] <= nums[nums.length - 1]) {
            return nums[0];
        }

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = (right - left) / 2 + left;
            if (mid - 1 >= 0 && nums[mid] < nums[mid - 1]) {
                return nums[mid];
            }


            if (nums[mid] < nums[right]) {
                right = mid;
            } else {
                left = mid + 1;
            }

        }

        return nums[left];

    }
}