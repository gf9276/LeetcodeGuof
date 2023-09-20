package com.guof.sort_and_search.color_classification;

/**
 * ClassName: Solution
 * Package: com.feng.sort_and_search.color_classification
 * Description:
 *
 * @Author guof
 * @Create 2023/4/16 16:36
 * @Version 1.0
 */
class Solution {
    public void sortColors(int[] nums) {
        int idx = 0;
        int left_idx = 0;
        int right_idx = nums.length - 1;

        while (idx <= right_idx) {
            if (nums[idx] == 0) {
                int tmp = nums[left_idx];
                nums[left_idx] = nums[idx];
                nums[idx] = tmp;
                left_idx++;
                idx++; // 这个很重要，挪完直接往后走就是了，因为前面不可能有2的，2早就被挪完了
            } else if (nums[idx] == 1) {
                idx++;
            } else if (nums[idx] == 2) {
                int tmp = nums[right_idx];
                nums[right_idx] = nums[idx];
                nums[idx] = tmp;
                right_idx--;
                // 这里不能idx++，因为还要判断挪过来的数字是不是0
            }
        }
    }
}