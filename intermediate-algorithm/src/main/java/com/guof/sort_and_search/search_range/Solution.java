package com.guof.sort_and_search.search_range;

class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[]{-1, -1};
        }

        int left = 0, right = nums.length - 1;
        int mid = 0;
        int first = -1;

        while (left <= right) // 二分
        {
            mid = left + right;
            mid /= 2;

            if (nums[mid] == target) {
                first = mid;
                right = mid - 1; // 可能还在前面
            } else if (nums[mid] > target) {
                right = mid - 1; // 还在前面
            } else if (nums[mid] < target) {
                left = mid + 1; // 还在后面
            }
        }
        if (first == -1) return new int[]{-1, -1};

        left = first;
        right = nums.length - 1;
        int last = -1;
        while (left <= right) // 找尾巴
        {
            mid = left + right;
            mid /= 2;

            if (nums[mid] == target) {
                last = mid;
                left = mid + 1; // 可能还在后面
            } else if (nums[mid] > target) {
                right = mid - 1; // 还在前面
            } else if (nums[mid] < target) {
                left = mid + 1; // 还在后面
            }
        }
        return new int[]{first, last};
    }
}
