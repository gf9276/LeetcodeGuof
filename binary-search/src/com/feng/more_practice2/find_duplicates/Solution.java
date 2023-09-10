package com.feng.more_practice2.find_duplicates;


class Solution {
    public int findDuplicate(int[] nums) {
        // 感觉这和二分法没什么关系，长得像而已

        int left = 1;  // 1
        int right = nums.length - 1; // n

        while (left < right) {
            int mid = (right - left) / 2 + left; // 1和n的中间值
            int cnt = 0;
            for (int num : nums) {
                if (num <= mid) {
                    cnt++;
                }
            }

            if (cnt > mid) {
                // 如果数量比mid大，说明重复值在1，mid之间
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;

    }
}