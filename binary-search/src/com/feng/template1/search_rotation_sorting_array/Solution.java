package com.feng.template1.search_rotation_sorting_array;

class Solution {
    public int search(int[] nums, int target) {

        if (target > nums[nums.length - 1] && target < nums[0]) {
            return -1;
        }

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (target == nums[mid]) {
                // 如果刚好相等，直接返回
                return mid;
            }
            if (target == nums[left]) {
                // 如果刚好相等，直接返回
                return left;
            }
            if (target == nums[right]) {
                // 如果刚好相等，直接返回
                return right;
            }

            if (nums[mid] > nums[left]) {
                // 在左区间
                if (target < nums[mid] && target > nums[left]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                // 在右区间
                if (target > nums[mid] && target < nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }

            }
        }
        return -1;
    }
}