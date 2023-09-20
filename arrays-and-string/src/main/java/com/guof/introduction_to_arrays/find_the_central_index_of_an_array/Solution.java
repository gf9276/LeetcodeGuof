package com.guof.introduction_to_arrays.find_the_central_index_of_an_array;

/**
 * ClassName: Solution
 * Package: com.feng.applying_basic_algorithmic_ideas.merge
 * Description:
 *
 * @Author guof
 * @Create 2023/5/15 21:32
 * @Version 1.0
 */
class Solution {
    public int pivotIndex(int[] nums) {
        int sum_right = 0;
        for (int num : nums) {
            sum_right += num;
        }
        int sum_left = 0;
        int idx = -1;

        for (int i = 0; i < nums.length; i++) {
            if (sum_left == sum_right-nums[i]) {
                idx = i;
                break;
            }
            sum_left += nums[i];
            sum_right -= nums[i];
        }
        return idx;
    }
}