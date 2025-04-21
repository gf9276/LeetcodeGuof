package com.guof.binary_search.others.lc_154;

class Solution {
    public int findMin(int[] nums) {
        // 注意相同的值就行
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            if (nums[right] > nums[left]) {
                return nums[left];
            }
            int mid = (right - left) / 2 + left;

            if (nums[mid] > nums[left]) {
                left = mid + 1;
            } else if (nums[mid] == nums[left]) {
                left++;
            } else {
                right = mid;
            }
        }
        return nums[left];
    }
}