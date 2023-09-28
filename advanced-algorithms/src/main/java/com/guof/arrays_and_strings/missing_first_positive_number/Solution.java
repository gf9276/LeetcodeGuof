package com.guof.arrays_and_strings.missing_first_positive_number;

import java.util.Arrays;

/**
 * ClassName: Solution
 * Package: com.feng.dynamic_programming.climb_stairs
 * Description:
 *
 * @Author guof
 * @Create 2023/3/27 22:23
 * @Version 1.0
 */
class Solution {
    public int firstMissingPositive(int[] nums) {
        Arrays.sort(nums); // 升序

        int left = 0;
        int right = nums.length;

        while (left < right) {
            int mid = (right - left) / 2 + left;

            if (nums[mid] <= 0) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        // 正数起始
        int beginIdx = left;
        int curValue = 1;
        if (beginIdx == nums.length || nums[beginIdx] != 1) {
            return 1;
        }

        for (int i = beginIdx + 1; i < nums.length; i++) {
            if (nums[i] != curValue && nums[i] != (curValue + 1)) {
                return curValue + 1;
            }
            curValue = nums[i];
        }
        return curValue + 1;
    }
}