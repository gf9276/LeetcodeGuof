package com.feng.template3.find_the_first_and_last_positions_of_elements_in_a_sorted_array;

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] output = new int[2];
        output[0] = -1;
        output[1] = -1;

        if (nums.length == 0) return output;

        int left = 0;
        int right = nums.length - 1;

        while (left + 1 < right) {

            int mid = (right - left) / 2 + left;
            if (nums[mid] >= target) {
                right = mid;
            } else {
                left = mid;
            }
        }

        if (nums[left] == target) {
            output[0] = left;
        } else if (nums[right] == target) {
            output[0] = right;
        }


        left = 0;
        right = nums.length - 1;

        while (left + 1 < right) {
            int mid = (right - left) / 2 + left;
            if (nums[mid] > target) {
                right = mid;
            } else {
                left = mid;
            }
        }

        if (nums[right] == target) {
            output[1] = right;
        } else if (nums[left] == target) {
            output[1] = left;
        }

        return output;
    }

}