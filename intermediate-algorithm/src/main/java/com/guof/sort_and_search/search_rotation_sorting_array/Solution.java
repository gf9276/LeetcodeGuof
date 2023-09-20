package com.guof.sort_and_search.search_rotation_sorting_array;

/**
 * ClassName: Solution
 * Package: com.feng.sort_and_search.search_rotation_sorting_array
 * Description:
 *
 * @Author guof
 * @Create 2023/4/23 11:16
 * @Version 1.0
 */
class Solution {
    public int search(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;
        int mid;


        while (left <= right) {
            mid = left + right;
            mid /= 2; // 获取中间值

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
                // 说明在有序区间内，不知道是哪个有序区间
                if (target < nums[mid] && target >= nums[left]) {
                    right = mid - 1; // 说明元素在左边
                } else {
                    // 说明元素在右边
                    left = mid + 1;
                }
            } else {
                // left,right 不在有序区间内
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1; // 说明元素在右边
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}
