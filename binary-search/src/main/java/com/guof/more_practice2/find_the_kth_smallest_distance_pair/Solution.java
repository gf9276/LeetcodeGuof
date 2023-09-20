package com.guof.more_practice2.find_the_kth_smallest_distance_pair;


import java.util.Arrays;

class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);

        int left = 0;
        int right = nums[nums.length - 1] - nums[0];


        while (left <= right) {
            int mid = (right - left) / 2 + left;

            // 统计小于mid的个数
            int cnt = countLessEquals(nums, mid);
            if (cnt < k) {
                // 不达标
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    public int countLessEquals(int[] nums, int mid) {
        int count = 0;
        int len = nums.length;
        for (int left = 0, right = 0; right < len; right++) {
            while (nums[right] - nums[left] > mid) {
                left++;
            }
            count += right - left;
        }
        return count;
    }

}