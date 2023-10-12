package com.guof.find_the_concatenated_values_of_an_array;


class Solution {
    public long findTheArrayConcVal(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        long output = 0;

        while (left < right) {
            output += Long.parseLong(String.valueOf(nums[left]) + String.valueOf(nums[right]));
            left++;
            right--;
        }

        if (left == right) {
            output += nums[left];
        }

        return output;
    }
}