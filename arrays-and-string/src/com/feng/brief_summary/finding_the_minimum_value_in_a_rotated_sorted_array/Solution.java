package com.feng.brief_summary.finding_the_minimum_value_in_a_rotated_sorted_array;

/**
 * ClassName: Solution
 * Package: com.feng.applying_basic_algorithmic_ideas.merge
 * Description: 中心回文，简单粗暴~
 *
 * @Author guof
 * @Create 2023/5/15 21:32
 * @Version 1.0
 */
class Solution {
    public int findMin(int[] nums) {
        if (nums.length == 1 || (nums[0] < nums[1] && nums[0] < nums[nums.length - 1])) {
            return nums[0];
        }

        // 应该用二分法吧？

        int left = 0;
        int right = nums.length - 1;


        while (left <= right) {
            int mid = (left + right) / 2;

            if (nums[mid] == nums[left] || nums[mid] == nums[right]) {
                return Math.min(nums[left], nums[right]);
            }

            if (nums[mid] > nums[left]) {
                // 起码说明左侧是递增的
                left = mid;
            } else {
                right = mid;
            }


        }
        return 0;

    }
}