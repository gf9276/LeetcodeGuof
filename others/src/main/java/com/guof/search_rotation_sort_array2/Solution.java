package com.guof.search_rotation_sort_array2;


class Solution {
    public int findMin(int[] nums) {
        // 这题简单就简单在，是0~n-1有序的

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = (right - left) / 2 + left;
            if (nums[mid] >= nums[left]) {
                if (nums[left] < nums[right]) {
                    return nums[left];
                } else {
                    left = mid + 1;
                }
            } else {
                right = mid;
            }
        }
        return nums[left % nums.length];
    }
}