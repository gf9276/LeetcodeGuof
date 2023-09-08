package com.feng.template3.find_peak;

class Solution {
    public int findPeakElement(int[] nums) {

        int left = 0;
        int right = nums.length - 1;

        while (left + 1 < right) {
            int mid = (right - left) / 2 + left;

            if (nums[mid] > nums[mid + 1] && nums[mid] > nums[mid - 1]) {
                return mid;
            }

            if (nums[mid] > nums[mid + 1]) {
                right = mid;
            } else {
                left = mid;
            }
        }

        return nums[left] > nums[right] ? left : right;
    }
}