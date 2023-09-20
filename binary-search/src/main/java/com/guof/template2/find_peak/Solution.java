package com.guof.template2.find_peak;

class Solution {
    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = (right - left) / 2 + left;
            if ((mid - 1 < 0 || nums[mid] > nums[mid - 1]) && (mid + 1 >= nums.length || nums[mid] > nums[mid + 1])) {
                return mid;
            }

            if (nums[mid] > nums[mid + 1]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}