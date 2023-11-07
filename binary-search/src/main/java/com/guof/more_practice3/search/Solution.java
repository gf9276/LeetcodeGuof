package com.guof.more_practice3.search;

class Solution {
    public int search(int[] nums, int target) {
        // 这题写过很多次了，不能不会写了

        //

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = (right - left) / 2 + left;

            if (target == nums[mid]) {
                return mid;
            }

            // 直接把三种情况写出来，谁让他独一无二的，开个挂
            if (nums[left] > nums[right] && nums[mid] < nums[left] && nums[mid] < nums[right]) {
                // 中间值在最下面的那种
                if (target > nums[mid]) {
                    if (target > nums[right]) {
                        right = mid - 1;
                    } else if (target < nums[right]) {
                        left = mid + 1;
                    } else {
                        return right;
                    }
                } else {
                    right = mid - 1;
                }
            } else if (nums[left] > nums[right] && nums[mid] > nums[left] && nums[mid] > nums[right]) {
                // 中间值在上面的那种
                if (target > nums[mid]) {
                    left = mid + 1;
                } else {
                    if (target > nums[left]) {
                        right = mid - 1;
                    } else if (target < nums[left]) {
                        left = mid + 1;
                    } else {
                        return left;
                    }
                }
            } else if (nums[left] < nums[right]) {
                // 最后一种最好了，递增的直线
                if (target > nums[mid]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                // 最后一种最好了，递增的直线
                if (target > nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }

        }
        return -1;
    }
}